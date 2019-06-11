package com.ttvcloud.service;

import com.ttvcloud.model.SdkResponse;
import com.ttvcloud.model.ServiceInfo;
import org.apache.http.client.HttpClient;

import java.util.Map;

public interface VcloudService {

    public void setClientNoReuse();

    public void setAccessKey(String accessKey);

    public void setSecretKey(String secretKey);

    public void setRegion(String region);

    public void setHttpClient(HttpClient httpClient);

    public void setServiceInfo(ServiceInfo serviceInfo);

    public void setSocketTimeout(int socketTimeout);

    public void setConnectionTimeout(int connectionTimeout);

    public SdkResponse query(String api, Map<String, String> query);

    public String getSignUrl(String api, Map<String, String> query) throws Exception;

    public SdkResponse json(String api, Map<String, String> query, String body);

    public SdkResponse post(String api, Map<String, String> query, Map<String, String> form);

}
