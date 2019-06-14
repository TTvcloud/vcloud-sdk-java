package com.bytedanceapi.model;

public class SdkResponse {

    private byte[] data;
    private int code;
    private Exception exception;


    public SdkResponse(byte[] data, int code, Exception e) {
        this.data = data;
        this.code = code;
        this.exception = e;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
