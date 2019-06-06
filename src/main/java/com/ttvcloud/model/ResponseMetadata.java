package com.ttvcloud.model;

public class ResponseMetadata {

    private String RequestId;
    private String Service;
    private String Region;
    private String Action;
    private String Version;
    private ErrorObj Error;

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public ErrorObj getError() {
        return Error;
    }

    public void setError(ErrorObj error) {
        Error = error;
    }

    @Override
    public String toString() {
        return "ResponseMetadata{" +
                "RequestId='" + RequestId + '\'' +
                ", Service='" + Service + '\'' +
                ", Region='" + Region + '\'' +
                ", Action='" + Action + '\'' +
                ", Version='" + Version + '\'' +
                ", Error=" + Error +
                '}';
    }
}
