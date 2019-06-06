package com.ttvcloud.model;

public class ErrorObj {

    private String Status;
    private String Message;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "ErrorObj{" +
                "Status='" + Status + '\'' +
                ", Message='" + Message + '\'' +
                '}';
    }
}
