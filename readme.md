# oss 
## default aliyun



### application.yml
```
storage:
  endPoint: ***
  accessKeyId: ***
  secretAccessKey: ***
  bucketName: ***
  prefixPath: ***
  cdnBaseURL: ***
```




### project
#### config class
```
@Component
@ConfigurationProperties(prefix = "storage")
public class ProStorageConfig extends StorageConfParams {
}
```


#### use
```
    @Autowired
    private StorageClient storageClient;

```