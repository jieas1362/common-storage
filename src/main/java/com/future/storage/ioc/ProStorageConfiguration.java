package com.future.storage.ioc;

import com.future.storage.api.conf.StorageConf;
import com.future.storage.inter.StorageClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;

import static com.future.storage.api.generator.StorageClientGenerator.generateStorageClient;

/**
 * storage configuration
 *
 * @author liuyunfei
 */
@SuppressWarnings({"AlibabaRemoveCommentedCode"})
@ConditionalOnBean(value = {StorageConf.class})
@AutoConfiguration
public class ProStorageConfiguration {

    @Bean
    StorageClient storageClient(StorageConf StorageConf) {
        return generateStorageClient(StorageConf);
    }

}
