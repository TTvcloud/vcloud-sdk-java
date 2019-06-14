## TTVcloud SDK for Java

#### vod 播放：
```
        VodService vodService = VodServiceImpl.getInstance();

        Map<String, String> query = new HashMap<String, String>();
        query.put("video_id", "your vid");

        vodService.setAccessKey("your ak");
        vodService.setSecretKey("your sk");

        VodResponse response = vodService.getPlayInfo(query);
        if (response.getCode() == 0){
            GetPlayInfoResp getPlayInfoResp = (GetPlayInfoResp) response.getResp();
            System.out.println(getPlayInfoResp);
        } else {
            System.out.println(response);
        }
```
##### 更多示例参见src/test/java/com/ttvcloud/example

注：ak、sk可放入环境变量，也可以json格式放在～/.vcloud/config中

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