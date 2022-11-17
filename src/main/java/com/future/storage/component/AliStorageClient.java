package com.future.storage.component;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.StorageClass;
import com.future.storage.api.conf.StorageConf;
import com.future.storage.inter.StorageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.UUID;

import static com.future.base.util.base.ProChecker.*;

/**
 * ali storage client
 *
 * @author liuyunfei
 */
@SuppressWarnings({"JavaDoc", "unused"})
public class AliStorageClient implements StorageClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(AliStorageClient.class);

    private final OSS oss;

    private final String bucketName;

    private final String prefixPath;

    private final String cdnBaseURL;

    public AliStorageClient(StorageConf conf) {
        LOGGER.info("conf = {}", conf);
        assertConf(conf);

        this.oss = new OSSClientBuilder().build(conf.getEndPoint(), conf.getAccessKeyId(), conf.getSecretAccessKey());
        this.bucketName = conf.getBucketName();
        this.prefixPath = conf.getPrefixPath();
        this.cdnBaseURL = conf.getCdnBaseURL();
    }

    /**
     * 生成随机标识
     *
     * @return
     */
    private String guid() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }

    /**
     * 根据objectName和 文件流构造请求对象
     *
     * @param objectName
     * @param file
     * @return
     */
    private PutObjectRequest createPutObjectRequest(String objectName, InputStream file) {
        // 设置存储类型与访问权限
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        metadata.setObjectAcl(CannedAccessControlList.PublicRead);

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, file);
        putObjectRequest.setMetadata(metadata);

        return putObjectRequest;
    }

    @Override
    public String uploadFile(InputStream fileInputStream, String suffix) {
        return uploadFile(guid(), fileInputStream, suffix);
    }

    @Override
    public String uploadFile(String fileName, InputStream file, String suffix) {
        String objectName = isNotBlank(suffix) ?
                prefixPath + fileName + suffix.replaceAll(" ", "") :
                prefixPath + fileName;
        PutObjectRequest putObjectRequest = createPutObjectRequest(objectName, file);
        oss.putObject(putObjectRequest);
        return cdnBaseURL + objectName;
    }

    @Override
    public void deleteFile(String cdnUrl) {
        String objName = cdnUrl.replace(cdnBaseURL, "");
        if (objName.startsWith("/")) {
            objName = objName.substring(1);
        }
        oss.deleteObject(bucketName, objName);
    }

    /**
     * assert params
     *
     * @param conf
     */
    private static void assertConf(StorageConf conf) {
        if (isNull(conf))
            throw new RuntimeException("conf can't be null");

        if (isBlank(conf.getEndPoint()))
            throw new RuntimeException("endPoint can't be blank");

        if (isBlank(conf.getAccessKeyId()))
            throw new RuntimeException("accessKeyId can't be blank");

        if (isBlank(conf.getSecretAccessKey()))
            throw new RuntimeException("secretAccessKey can't be blank");

        if (isBlank(conf.getBucketName()))
            throw new RuntimeException("bucketName can't be blank");

        if (isBlank(conf.getPrefixPath()))
            throw new RuntimeException("prefixPath can't be blank");

        if (isBlank(conf.getCdnBaseURL()))
            throw new RuntimeException("cdnBaseURL can't be blank");
    }

}
