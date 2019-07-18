package com.bytedanceapi.service;

import com.bytedanceapi.model.response.RawResponse;
import org.apache.http.client.HttpClient;

import java.util.Map;

/**
 * The interface Service.
 */
public interface IBaseService {

    /**
     * Sets client no reuse.
     */
    void setClientNoReuse();

    /**
     * Gets access key.
     *
     * @return the access key
     */
    String getAccessKey();

    /**
     * Sets access key.
     *
     * @param accessKey the access key
     */
    void setAccessKey(String accessKey);

    /**
     * Gets secret key.
     *
     * @return the secret key
     */
    String getSecretKey();

    /**
     * Sets secret key.
     *
     * @param secretKey the secret key
     */
    void setSecretKey(String secretKey);

    /**
     * Sets region.
     *
     * @param region the region
     */
    void setRegion(String region);

    /**
     * Sets http client.
     *
     * @param httpClient the http client
     */
    void setHttpClient(HttpClient httpClient);

    /**
     * Sets service info.
     *
     * @param serviceInfo the service info
     */
    void setServiceInfo(com.bytedanceapi.model.ServiceInfo serviceInfo);

    /**
     * Sets socket timeout.
     *
     * @param socketTimeout the socket timeout
     */
    void setSocketTimeout(int socketTimeout);

    /**
     * Sets connection timeout.
     *
     * @param connectionTimeout the connection timeout
     */
    void setConnectionTimeout(int connectionTimeout);

    /**
     * Query raw response.
     *
     * @param api    the api
     * @param params the params
     * @return the raw response
     */
    RawResponse query(String api, Map<String, String> params) throws Exception;

    /**
     * Gets sign url.
     *
     * @param api    the api
     * @param params the params
     * @return the sign url
     * @throws Exception the exception
     */
    String getSignUrl(String api, Map<String, String> params) throws Exception;

    /**
     * Json raw response.
     *
     * @param api    the api
     * @param params the params
     * @param body   the body
     * @return the raw response
     */
    RawResponse json(String api, Map<String, String> params, String body) throws Exception;

    /**
     * Post raw response.
     *
     * @param api    the api
     * @param params the params
     * @param form   the form
     * @return the raw response
     */
    RawResponse post(String api, Map<String, String> params, Map<String, String> form) throws Exception;

    boolean put(String url, String filePath, Map<String, String> headers) throws Exception;
}
