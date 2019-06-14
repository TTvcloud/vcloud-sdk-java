package com.bytedanceapi.model;

import com.bytedanceapi.util.Const;
import org.apache.http.Header;

import java.util.List;
import java.util.Map;

import static com.bytedanceapi.util.Const.*;

@SuppressWarnings("unchecked")
public class ServiceInfo {

    private int connectionTimeout;
    private int socketTimeout;
    private String host;
    private List<Header> header;
    private Credentials credentials;

    public ServiceInfo(Map<String, Object> params) {
        this.connectionTimeout = ((Integer) params.get(ConnectionTimeout)) == null ? 0: (Integer) params.get(ConnectionTimeout);
        this.socketTimeout = ((Integer) params.get(SocketTimeout)) == null ? 0 : (Integer) params.get(SocketTimeout);
        this.host = (String) params.get(Host);
        this.header = (List<Header>) params.get(Const.Header);
        this.credentials = (Credentials) params.get(Const.Credentials);
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public List<Header> getHeader() {
        return header;
    }

    public void setHeader(List<Header> header) {
        this.header = header;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}



