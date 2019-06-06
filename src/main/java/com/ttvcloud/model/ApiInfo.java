package com.ttvcloud.model;

import org.apache.http.Header;
import org.apache.http.NameValuePair;

import java.util.List;
import java.util.Map;

import static com.ttvcloud.util.Const.*;

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
        this.method = (String) params.get(Method);
        this.path = (String) params.get(Path);
        this.query = (List<NameValuePair>) params.get(Query);
        this.form = (List<NameValuePair>) params.get(Form);
        this.connectionTimeout = ((Integer) params.get(ConnectionTimeout)) == null? 0 : (Integer) params.get(ConnectionTimeout);
        this.socketTimeout = ((Integer) params.get(SocketTimeout)) == null? 0 : (Integer) params.get(SocketTimeout);
        this.header = (List<Header>) params.get(Header);
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
