package com.ttvcloud.model.vod;

public class VodResponse {

    private int code;
    private Object resp;
    private Exception exception;

    public VodResponse(int code, Object resp, Exception exception) {
        this.code = code;
        this.resp = resp;
        this.exception = exception;
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

    public Object getResp() {
        return resp;
    }

    public void setResp(Object resp) {
        this.resp = resp;
    }

    @Override
    public String toString() {
        return "VodResponse{" +
                "code=" + code +
                ", exception=" + exception +
                ", resp=" + resp +
                '}';
    }
}
