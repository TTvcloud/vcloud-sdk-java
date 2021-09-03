package com.bytedanceapi.service;

import com.alibaba.fastjson.JSON;
import com.bytedanceapi.auth.ISignerV4;
import com.bytedanceapi.auth.impl.SignerV4Impl;
import com.bytedanceapi.error.SdkError;
import com.bytedanceapi.helper.Const;
import com.bytedanceapi.http.ClientConfiguration;
import com.bytedanceapi.http.HttpClientFactory;
import com.bytedanceapi.model.ApiInfo;
import com.bytedanceapi.model.Credentials;
import com.bytedanceapi.model.ServiceInfo;
import com.bytedanceapi.model.response.RawResponse;
import com.bytedanceapi.model.sts2.InnerToken;
import com.bytedanceapi.model.sts2.Policy;
import com.bytedanceapi.model.sts2.SecurityToken2;
import com.bytedanceapi.util.Sts2Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class BaseServiceImpl implements IBaseService {


    private static final Log LOG = LogFactory.getLog(BaseServiceImpl.class);
    protected ServiceInfo serviceInfo;
    protected Map<String, ApiInfo> apiInfoList;
    private HttpClient httpClient;
    private ISignerV4 ISigner;
    private int socketTimeout;
    private int connectionTimeout;


    public BaseServiceImpl(ServiceInfo info, Map<String, ApiInfo> apiInfoList) {
        this.serviceInfo = info;
        this.apiInfoList = apiInfoList;
        this.ISigner = new SignerV4Impl();

        this.httpClient = HttpClientFactory.create(new ClientConfiguration());

        String accessKey = System.getenv(Const.ACCESS_KEY);
        String secretKey = System.getenv(Const.SECRET_KEY);

        if (accessKey != null && !accessKey.equals("") && secretKey != null && !secretKey.equals("")) {
            info.getCredentials().setAccessKeyID(accessKey);
            info.getCredentials().setSecretAccessKey(secretKey);
        } else {
            File file = new File(System.getenv("HOME") + "/.vcloud/config");
            if (file.exists()) {
                try {
                    long length = file.length();
                    byte[] content = new byte[(int) length];
                    FileInputStream in = new FileInputStream(file);
                    in.read(content);
                    in.close();
                    Credentials credentials = JSON.parseObject(content, Credentials.class);
                    if (credentials.getAccessKeyID() != null) {
                        info.getCredentials().setAccessKeyID(credentials.getAccessKeyID());
                    }
                    if (credentials.getSecretAccessKey() != null) {
                        info.getCredentials().setSecretAccessKey(credentials.getSecretAccessKey());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LOG.error("Read file " + file.getName() + " fail.");
                }
            }
        }
    }

    @Override
    public String getSignUrl(String api, List<NameValuePair> params) throws Exception {
        ApiInfo apiInfo = apiInfoList.get(api);

        if (apiInfo == null) {
            throw new Exception(SdkError.getErrorDesc(SdkError.ENOAPI));
        }

        List<NameValuePair> mergedNV = mergeQuery(params, apiInfo.getQuery());

        SignableRequest request = new SignableRequest();
        URIBuilder builder = request.getUriBuilder();

        request.setMethod(apiInfo.getMethod().toUpperCase());
        builder.setScheme(serviceInfo.getScheme());
        builder.setHost(serviceInfo.getHost());
        builder.setPath(apiInfo.getPath());
        builder.setParameters(mergedNV);

        return ISigner.signUrl(request, serviceInfo.getCredentials());
    }

    @Override
    public RawResponse query(String api, List<NameValuePair> params) {
        ApiInfo apiInfo = apiInfoList.get(api);
        if (apiInfo == null) {
            return new RawResponse(null, SdkError.ENOAPI.getNumber(), new Exception(SdkError.getErrorDesc(SdkError.ENOAPI)));
        }

        SignableRequest request = prepareRequest(api, params);
        return makeRequest(api, request);
    }

    @Override
    public boolean put(String url, String filePath, Map<String, String> headers) {
        HttpEntity httpEntity = new FileEntity(new File(filePath));
        return doPut(url, httpEntity, headers);
    }

    @Override
    public boolean putData(String url, byte[] data, Map<String, String> headers) {
        HttpEntity httpEntity = new ByteArrayEntity(data);
        return doPut(url, httpEntity, headers);
    }

    private boolean doPut(String url, HttpEntity entity, Map<String, String> headers) {
        HttpPut httpPut = new HttpPut(url);
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPut.setHeader(entry.getKey(), entry.getValue());
            }
        }
        httpPut.setEntity(entity);
        HttpResponse response = null;
        try {
            HttpClient client;
            if (getHttpClient() != null) {
                client = getHttpClient();
            } else {
                client = HttpClients.createDefault();
            }
            response = client.execute(httpPut);
            if (response.getStatusLine().getStatusCode() == 200) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                EntityUtils.consumeQuietly(response.getEntity());
            }
        }
        return false;
    }

    @Override
    public RawResponse json(String api, List<NameValuePair> params, String body) {
        ApiInfo apiInfo = apiInfoList.get(api);
        if (apiInfo == null) {
            return new RawResponse(null, SdkError.ENOAPI.getNumber(), new Exception(SdkError.getErrorDesc(SdkError.ENOAPI)));
        }

        SignableRequest request = prepareRequest(api, params);
        request.setHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(body, "utf-8"));
        return makeRequest(api, request);
    }

    @Override
    public RawResponse post(String api, List<NameValuePair> query, List<NameValuePair> form) {
        ApiInfo apiInfo = apiInfoList.get(api);
        if (apiInfo == null) {
            return new RawResponse(null, SdkError.ENOAPI.getNumber(), new Exception(SdkError.getErrorDesc(SdkError.ENOAPI)));
        }

        SignableRequest request = prepareRequest(api, query);
        request.setHeader("Content-Type", "application/x-www-form-urlencoded");
        List<NameValuePair> mergedForm = mergeQuery(form, apiInfo.getForm());

        try {
            Collections.sort(mergedForm, new Comparator<NameValuePair>() {
                @Override
                public int compare(NameValuePair o1, NameValuePair o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            request.setEntity(new UrlEncodedFormEntity(mergedForm));
        } catch (Exception e) {
            return new RawResponse(null, SdkError.EENCODING.getNumber(), e);
        }
        return makeRequest(api, request);
    }

    private RawResponse makeRequest(String api, SignableRequest request) {
        try {
            ISigner.sign(request, serviceInfo.getCredentials());
        } catch (Exception e) {
            return new RawResponse(null, SdkError.ESIGN.getNumber(), e);
        }
        HttpClient client;
        HttpResponse response = null;
        try {
            if (getHttpClient() != null) {
                client = getHttpClient();
            } else {
                client = HttpClients.createDefault();
            }
            response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode >= 300) {
                return new RawResponse(null, SdkError.EHTTP.getNumber(), new Exception(SdkError.getErrorDesc(SdkError.EHTTP)));
            }
            byte[] bytes = EntityUtils.toByteArray(response.getEntity());
            return new RawResponse(bytes, SdkError.SUCCESS.getNumber(), null);
        } catch (Exception e) {
            if (response != null) {
                EntityUtils.consumeQuietly(response.getEntity());
            }
            return new RawResponse(null, SdkError.EHTTP.getNumber(), new Exception(SdkError.getErrorDesc(SdkError.EHTTP)));
        }
    }

    private SignableRequest prepareRequest(String api, List<NameValuePair> params) {
        ApiInfo apiInfo = apiInfoList.get(api);

        int socketTimeout = getSocketTimeout(serviceInfo.getSocketTimeout(), apiInfo.getSocketTimeout());
        int connectionTimeout = getConnectionTimeout(serviceInfo.getConnectionTimeout(), apiInfo.getConnectionTimeout());
        SignableRequest request = new SignableRequest();
        request.setMethod(apiInfo.getMethod().toUpperCase());

        Collection<Header> mergedH = mergeHeader(serviceInfo.getHeader(), apiInfo.getHeader());
        for (Header header : mergedH) {
            request.setHeader(header);
        }
        List<NameValuePair> mergedNV = mergeQuery(params, apiInfo.getQuery());
        URIBuilder builder = request.getUriBuilder();

        builder.setScheme(serviceInfo.getScheme());
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
        Set<Header> set = new HashSet<>();
        if (header1 != null) {
            set.addAll(header1);
        }
        if (header2 != null) {
            set.addAll(header2);
        }
        return set;
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

    @Override
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

    @Override
    public String getAccessKey() {
        return serviceInfo.getCredentials().getAccessKeyID();
    }

    @Override
    public void setAccessKey(String accessKey) {
        serviceInfo.getCredentials().setAccessKeyID(accessKey);
    }

    @Override
    public String getSecretKey() {
        return serviceInfo.getCredentials().getSecretAccessKey();
    }

    @Override
    public void setSecretKey(String secretKey) {
        serviceInfo.getCredentials().setSecretAccessKey(secretKey);
    }

    @Override
    public void setRegion(String region) {
        serviceInfo.getCredentials().setRegion(region);
    }

    @Override
    public void setHost(String host) {
        serviceInfo.setHost(host);
    }

    @Override
    public void setScheme(String scheme) {
        serviceInfo.setScheme(scheme);
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    @Override
    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    @Override
    public void setServiceInfo(ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public Map<String, ApiInfo> getApiInfoList() {
        return apiInfoList;
    }

    public ISignerV4 getISigner() {
        return ISigner;
    }

    @Override
    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    @Override
    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    @Override
    public SecurityToken2 signSts2(Policy inlinePolicy, long expire) throws Exception {
        SecurityToken2 sts2 = new SecurityToken2();
        sts2.setAccessKeyId(Sts2Utils.generateAccessKeyId("AKTP"));
        sts2.setSecretAccessKey(Sts2Utils.generateSecretKey());

        Date now = new Date();
        Date expireTime = new Date(now.getTime() + expire);
        sts2.setCurrentTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(now));
        sts2.setExpiredTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(expireTime));

        InnerToken innerToken = Sts2Utils.createInnerToken(serviceInfo.getCredentials(),sts2,inlinePolicy,expireTime.getTime()/1000);
        String sessionToken = "STS2" + Base64.getEncoder().encodeToString(JSON.toJSONString(innerToken).getBytes());
        sts2.setSessionToken(sessionToken);
        return sts2;
    }

}
