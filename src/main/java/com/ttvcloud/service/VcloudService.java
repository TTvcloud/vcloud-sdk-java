package com.ttvcloud.service;

import com.ttvcloud.auth.Signer;
import com.ttvcloud.model.ApiInfo;
import com.ttvcloud.model.SdkResponse;
import com.ttvcloud.model.ServiceInfo;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;

import java.util.List;
import java.util.Map;

public interface VcloudService {

    public void setClientNoReuse();

    public void setAccessKey(String accessKey);

    public void setSecretKey(String secretKey);

    public void setRegion(String region);

    public void setHttpClient(HttpClient httpClient);

    public void setServiceInfo(ServiceInfo serviceInfo);

    public void setApiInfoList(Map<String, ApiInfo> apiInfoList);

    public void setSigner(Signer signer);

    public void setSocketTimeout(int socketTimeout);

    public void setConnectionTimeout(int connectionTimeout);

    public SdkResponse query(String api, List<NameValuePair> query);

}
