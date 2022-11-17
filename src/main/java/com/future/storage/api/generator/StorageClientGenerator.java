package com.future.storage.api.generator;

import com.future.storage.api.conf.StorageConf;
import com.future.storage.component.AliStorageClient;
import com.future.storage.inter.StorageClient;

/**
 * storage components generator
 *
 * @author liuyunfei
 */
@SuppressWarnings({"JavaDoc", "unused"})
public final class StorageClientGenerator {

    /**
     * generate storage client
     *
     * @param storageConf
     * @return
     */
    public static StorageClient generateStorageClient(StorageConf storageConf) {
        return new AliStorageClient(storageConf);
    }

}
