package com.bytedanceapi.model;

import com.bytedanceapi.helper.Const;
import lombok.Data;
import org.apache.http.Header;

import java.util.List;
import java.util.Map;

import static com.bytedanceapi.helper.Const.*;

@Data
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
}



