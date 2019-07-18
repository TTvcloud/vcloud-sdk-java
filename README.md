## TTVcloud SDK for Java

#### maven依赖：
```
<dependency>
    <groupId>com.bytedanceapi</groupId>
    <artifactId>vcloud-sdk-java</artifactId>
    <version>${version}</version>
</dependency>
```

### API

#### 上传:
```
        // 从本地文件上传
        upload
        // 从url上传
        uploadMediaByUrl
```
#### 转码:
```
        // 开始转码
        startTranscode
```

#### 发布:
```
        // 设置发布状态
        setVideoPublishStatus
```
#### 播放：
```
        // 获取播放地址
        getPlayInfo
        // 获取源片播放地址
        getOriginVideoPlayInfo
        // 获取重定向302地址
        getRedirectPlay
```
#### 封面图:
```
        // 获取视频封面图播放地址
        getPosterUrl
```
#### 其它图片:
```
        // 获取其它图片地址（带鉴权串）
        getImageUrl
```

##### 更多示例参见src/test/java/com/bytedanceapi/example

注：ak、sk可放入环境变量，也可以json格式放在～/.vcloud/config中
格式为：{"ak":"","sk":""}

#### service可配置项：
```
    public void setClientNoReuse(); //不复用httpclient，每次通过HttpClients.createDefault()新建

    public void setAccessKey(String accessKey);

    public void setSecretKey(String secretKey);

    public void setRegion(String region);

    public void setHttpClient(HttpClient httpClient); //传入业务自己配置的httpclient

    public void setServiceInfo(ServiceInfo serviceInfo);

    public void setSocketTimeout(int socketTimeout);

    public void setConnectionTimeout(int connectionTimeout);
```

#### 创建httpClient:

```
//configuration可配置项：
//maxConnections 连接池最大连接数，默认1000;
//maxConPerRoute 每路由最大连接数，默认600;
//socketTimeout;
//connectionTimeout;
ClientConfiguration configuration = new Configuration();
HttpClientFactory.create(configuration);
```