package com.bytedance.open.model;

import com.google.gson.annotations.SerializedName;

public class ResponseMetadata {

    @SerializedName("RequestId")
    private String requestId;
    @SerializedName("Service")
    private String service;
    @SerializedName("Region")
    private String region;
    @SerializedName("Action")
    private String action;
    @SerializedName("Version")
    private String version;
    @SerializedName("Error")
    private ErrorObj error;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ErrorObj getError() {
        return error;
    }

    public void setError(ErrorObj error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResponseMetadata{" +
                "requestId='" + requestId + '\'' +
                ", service='" + service + '\'' +
                ", region='" + region + '\'' +
                ", action='" + action + '\'' +
                ", version='" + version + '\'' +
                ", error=" + error +
                '}';
    }
}
