package com.future.storage.api.conf;

/**
 * storage conf
 *
 * @author liuyunfei
 */
@SuppressWarnings({"AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc", "AlibabaCommentsMustBeJavadocFormat"})
public interface StorageConf {

    String getEndPoint();

    String getAccessKeyId();

    String getSecretAccessKey();

    String getBucketName();

    String getPrefixPath();

    String getCdnBaseURL();

}
