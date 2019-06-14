package com.bytedanceapi.model;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.utils.URIBuilder;

public class SignableRequest extends HttpEntityEnclosingRequestBase {

    private String method;

    private URIBuilder uriBuilder = new URIBuilder();

    @Override
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public URIBuilder getUriBuilder() {
        return uriBuilder;
    }

}
