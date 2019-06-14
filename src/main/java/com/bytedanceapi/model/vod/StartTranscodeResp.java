package com.bytedanceapi.model.vod;

import com.google.gson.annotations.SerializedName;

public class StartTranscodeResp {

    @SerializedName("ResponseMetadata")
    private com.bytedanceapi.model.ResponseMetadata responseMetadata;
    @SerializedName("Result")
    private StartTranscodeResult result;

    public com.bytedanceapi.model.ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

    public void setResponseMetadata(com.bytedanceapi.model.ResponseMetadata responseMetadata) {
        this.responseMetadata = responseMetadata;
    }

    public StartTranscodeResult getResult() {
        return result;
    }

    public void setResult(StartTranscodeResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "StartTranscodeResp{" +
                "responseMetadata=" + responseMetadata +
                ", result=" + result +
                '}';
    }
}
