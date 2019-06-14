package com.bytedanceapi.model;

import org.apache.http.Header;
import org.apache.http.NameValuePair;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ApiInfo {

    private String method;
    private String path;
    private List<NameValuePair> query;
    private List<NameValuePair> form;
    private int connectionTimeout;
    private int socketTimeout;
    private List<Header> header;

    public ApiInfo(Map<String, Object> params) {
        this.method = (String) params.get(com.bytedanceapi.util.Const.Method);
        this.path = (String) params.get(com.bytedanceapi.util.Const.Path);
        this.query = (List<NameValuePair>) params.get(com.bytedanceapi.util.Const.Query);
        this.form = (List<NameValuePair>) params.get(com.bytedanceapi.util.Const.Form);
        this.connectionTimeout = ((Integer) params.get(com.bytedanceapi.util.Const.ConnectionTimeout)) == null? 0 : (Integer) params.get(com.bytedanceapi.util.Const.ConnectionTimeout);
        this.socketTimeout = ((Integer) params.get(com.bytedanceapi.util.Const.SocketTimeout)) == null? 0 : (Integer) params.get(com.bytedanceapi.util.Const.SocketTimeout);
        this.header = (List<Header>) params.get(com.bytedanceapi.util.Const.Header);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<NameValuePair> getQuery() {
        return query;
    }

    public void setQuery(List<NameValuePair> query) {
        this.query = query;
    }

    public List<NameValuePair> getForm() {
        return form;
    }

    public void setForm(List<NameValuePair> form) {
        this.form = form;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public List<org.apache.http.Header> getHeader() {
        return header;
    }

    public void setHeader(List<org.apache.http.Header> header) {
        this.header = header;
    }
}
