package com.future.storage.inter;

import java.io.InputStream;

/**
 * 存储桶接口层
 *
 * @author liuyunfei
 */
@SuppressWarnings("JavadocDeclaration")
public interface StorageClient {

    /**
     * 上传文件
     *
     * @param fileInputStream
     * @param suffix
     * @return
     */
    String uploadFile(InputStream fileInputStream, String suffix);

    /**
     * 上传文件
     *
     * @param fileName
     * @param file
     * @param suffix
     * @return
     */
    String uploadFile(String fileName, InputStream file, String suffix);

    /**
     * 删除文件
     *
     * @param cdnUrl
     */
    void deleteFile(String cdnUrl);

}
