package com.future.storage.api.conf;

/**
 * redis params
 *
 * @author liuyunfei
 */
@SuppressWarnings({"unused", "AlibabaCommentsMustBeJavadocFormat"})
public class StorageConfParams implements StorageConf {

    protected transient String endPoint;

    protected transient String accessKeyId;

    protected transient String secretAccessKey;

    protected String bucketName;

    protected String prefixPath;

    protected String cdnBaseURL;

    public StorageConfParams() {
    }

    @Override
    public String getEndPoint() {
        return endPoint;
    }

    @Override
    public String getAccessKeyId() {
        return accessKeyId;
    }

    @Override
    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }

    @Override
    public String getPrefixPath() {
        return prefixPath;
    }

    @Override
    public String getCdnBaseURL() {
        return cdnBaseURL;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public void setPrefixPath(String prefixPath) {
        this.prefixPath = prefixPath;
    }

    public void setCdnBaseURL(String cdnBaseURL) {
        this.cdnBaseURL = cdnBaseURL;
    }

    @Override
    public String toString() {
        return "StorageConfParams{" +
                "endPoint='" + endPoint + '\'' +
                ", accessKeyId='" + accessKeyId + '\'' +
                ", secretAccessKey='" + secretAccessKey + '\'' +
                ", bucketName='" + bucketName + '\'' +
                ", prefixPath='" + prefixPath + '\'' +
                ", cdnBaseURL='" + cdnBaseURL + '\'' +
                '}';
    }

}
