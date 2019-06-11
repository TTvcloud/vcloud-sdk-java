package com.ttvcloud.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ttvcloud.auth.Signer;
import com.ttvcloud.auth.V4Signer;
import com.ttvcloud.http.ClientConfiguration;
import com.ttvcloud.http.HttpClientFactory;
import com.ttvcloud.model.ApiInfo;
import com.ttvcloud.model.SdkResponse;
import com.ttvcloud.model.ServiceInfo;
import com.ttvcloud.model.SignableRequest;
import com.ttvcloud.util.Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import static com.ttvcloud.util.Const.AccessKey;
import static com.ttvcloud.util.Const.SecretKey;

public abstract class BaseVcloudService implements VcloudService {


    private HttpClient httpClient;

    private ServiceInfo serviceInfo;

    private Map<String, ApiInfo> apiInfoList;

    private Signer signer;

    private int socketTimeout;

    private int connectionTimeout;

    private static final Log LOG = LogFactory.getLog(BaseVcloudService.class);


    public BaseVcloudService(ServiceInfo info, Map<String, ApiInfo> apiInfoList) {



        this.serviceInfo = info;
        this.apiInfoList = apiInfoList;
        this.signer = new V4Signer();

        this.httpClient = HttpClientFactory.create(new ClientConfiguration());

        String accessKey = System.getenv(AccessKey);
        String secretKey = System.getenv(SecretKey);

        if (accessKey != null && !accessKey.equals("") && secretKey!= null && !secretKey.equals("")) {
            info.getCredentials().setAccessKeyID(accessKey);
            info.getCredentials().setSecretAccessKey(secretKey);
        } else {
            File file = new File(System.getenv("HOME") + "/.vcloud/config");
            if (file.exists()) {
                try {
                    long filelength = file.length();
                    byte[] filecontent = new byte[(int)filelength];
                    FileInputStream in = new FileInputStream(file);
                    in.read(filecontent);
                    in.close();
                    Map<String, String> mmap = new Gson().fromJson(new String(filecontent), new TypeToken<Map<String, String>>(){}.getType());

                    if (mmap.get("ak") != null) {
                        info.getCredentials().setAccessKeyID(mmap.get("ak"));
                    }
                    if (mmap.get("sk") != null) {
                        info.getCredentials().setSecretAccessKey(mmap.get("sk"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LOG.error("Read file " + file.getName() + " fail.");
                }
            }
        }
    }

    @Override
    public String getSignUrl(String api, Map<String, String> query) throws Exception {
        ApiInfo apiInfo = apiInfoList.get(api);

        if (apiInfo == null) {
            throw new Exception("相关api不存在");
        }

        List<NameValuePair> mergedNV = mergeQuery(Utils.mapToPairList(query), apiInfo.getQuery());

        SignableRequest request = new SignableRequest();
        URIBuilder builder = request.getUriBuilder();

        request.setMethod(apiInfo.getMethod().toUpperCase());
        builder.setScheme("http");
        builder.setHost(serviceInfo.getHost());
        builder.setPath(apiInfo.getPath());
        builder.setParameters(mergedNV);

        return signer.signUrl(request, serviceInfo.getCredentials());
    }

    @Override
    public SdkResponse query(String api, Map<String, String> query) {
        ApiInfo apiInfo = apiInfoList.get(api);

        if (apiInfo == null) {
            return new SdkResponse(null, 500, new Exception("相关api不存在"));
        }

        SignableRequest request = prepareRequest(api, query);

        return makeRequest(api, request);
    }

    @Override
    public SdkResponse json(String api, Map<String, String> query, String body) {
        ApiInfo apiInfo = apiInfoList.get(api);

        if (apiInfo == null) {
            return new SdkResponse(null, 500, new Exception("相关api不存在"));
        }

        SignableRequest request = prepareRequest(api, query);

        request.setHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(body, "utf-8"));

        return makeRequest(api, request);
    }

    @Override
    public SdkResponse post(String api, Map<String, String> query, Map<String, String> form) {

        ApiInfo apiInfo = apiInfoList.get(api);

        if (apiInfo == null) {
            return new SdkResponse(null, 500, new Exception("相关api不存在"));
        }

        SignableRequest request = prepareRequest(api, query);

        request.setHeader("Content-Type", "application/x-www-form-urlencoded");
        List<NameValuePair> mergedForm = mergeQuery(Utils.mapToPairList(form), apiInfo.getForm());

        try {
            Collections.sort(mergedForm, new Comparator<NameValuePair>() {
                @Override
                public int compare(NameValuePair o1, NameValuePair o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            request.setEntity(new UrlEncodedFormEntity(mergedForm));
        } catch (Exception e) {
            return new SdkResponse(null, 500, e);
        }

        return makeRequest(api, request);
    }

    private SdkResponse makeRequest(String api, SignableRequest request) {
        try {
            signer.sign(request, serviceInfo.getCredentials());
        } catch (Exception e) {
            return new SdkResponse(null, 500, e);
        }
        try {
            HttpClient client;
            if (getHttpClient() != null) {
                client = getHttpClient();
            } else {
                client = HttpClients.createDefault();
            }
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode >= 300) {
                return new SdkResponse(null, statusCode,
                        new Exception(
                                "HTTP Request is not success, Response code is " + response.getStatusLine().getStatusCode()));
            }
            byte[] bytes = EntityUtils.toByteArray(response.getEntity());
            return new SdkResponse(bytes, 0, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new SdkResponse(null, 500, e);
        }
    }

    private SignableRequest prepareRequest(String api, Map<String, String> query) {
        ApiInfo apiInfo = apiInfoList.get(api);

        int socketTimeout = getSocketTimeout(serviceInfo.getSocketTimeout(), apiInfo.getSocketTimeout());
        int connectionTimeout = getConnectionTimeout(serviceInfo.getConnectionTimeout(), apiInfo.getConnectionTimeout());
        SignableRequest request = new SignableRequest();
        request.setMethod(apiInfo.getMethod().toUpperCase());

        Collection<Header> mergedH = mergeHeader(serviceInfo.getHeader(), apiInfo.getHeader());
        for (Header header : mergedH) {
            request.setHeader(header);
        }
        List<NameValuePair> mergedNV = mergeQuery(Utils.mapToPairList(query), apiInfo.getQuery());
        URIBuilder builder = request.getUriBuilder();

        builder.setScheme("http");
        builder.setHost(serviceInfo.getHost());
        builder.setPath(apiInfo.getPath());
        builder.setParameters(mergedNV);

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(socketTimeout)
                .setConnectTimeout(connectionTimeout)
                .build();
        request.setConfig(requestConfig);

        return request;
    }

    private Collection<Header> mergeHeader(List<Header> header1, List<Header> header2) {


        Map<String, Header> map = new HashMap<String, Header>();
        if (header1 != null) {
            for (Header header : header1) {
                map.put(header.getName(), header);
            }
        }

        if (header2 != null) {
            for (Header header : header2) {
                map.put(header.getName(), header);
            }
        }

        return map.values();
    }

    private List<NameValuePair> mergeQuery(List<NameValuePair> query1, List<NameValuePair> query2) {
        List<NameValuePair> res = new ArrayList<NameValuePair>();
        if (query1 != null) {
            res.addAll(query1);
        }
        if (query2 != null) {
            res.addAll(query2);
        }
        return res;
    }

    public void setClientNoReuse() {
        this.httpClient = null;
    }


    private int getConnectionTimeout(int serviceTimeout, int apiTimeout) {
        int timeout = 5000;
        if (serviceTimeout != 0) {
            timeout = serviceTimeout;
        }
        if (apiTimeout != 0) {
            timeout = apiTimeout;
        }
        if (connectionTimeout != 0) {
            timeout = connectionTimeout;
        }
        return timeout;
    }

    private int getSocketTimeout(int serviceTimeout, int apiTimeout) {
        int timeout = 5000;
        if (serviceTimeout != 0) {
            timeout = serviceTimeout;
        }
        if (apiTimeout != 0) {
            timeout = apiTimeout;
        }
        if (socketTimeout != 0) {
            timeout = socketTimeout;
        }
        return timeout;
    }


    public void setAccessKey(String accessKey) {
        serviceInfo.getCredentials().setAccessKeyID(accessKey);
    }

    public void setSecretKey(String secretKey) {
        serviceInfo.getCredentials().setSecretAccessKey(secretKey);
    }

    public void setRegion(String region) {
        serviceInfo.getCredentials().setRegion(region);
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public Map<String, ApiInfo> getApiInfoList() {
        return apiInfoList;
    }

    public Signer getSigner() {
        return signer;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

}
