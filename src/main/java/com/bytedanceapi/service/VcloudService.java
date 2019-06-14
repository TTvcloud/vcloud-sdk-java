package com.bytedanceapi.service;

import org.apache.http.client.HttpClient;

import java.util.Map;

public interface VcloudService {

    public void setClientNoReuse();

    public void setAccessKey(String accessKey);

    public void setSecretKey(String secretKey);

    public void setRegion(String region);

    public void setHttpClient(HttpClient httpClient);

    public void setServiceInfo(com.bytedanceapi.model.ServiceInfo serviceInfo);

    public void setSocketTimeout(int socketTimeout);

    public void setConnectionTimeout(int connectionTimeout);

    public com.bytedanceapi.model.SdkResponse query(String api, Map<String, String> query);

    public String getSignUrl(String api, Map<String, String> query) throws Exception;

    public com.bytedanceapi.model.SdkResponse json(String api, Map<String, String> query, String body);

    public com.bytedanceapi.model.SdkResponse post(String api, Map<String, String> query, Map<String, String> form);

}
