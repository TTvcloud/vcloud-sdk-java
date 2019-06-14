package com.bytedance.open.model.vod;

import com.google.gson.annotations.SerializedName;

public class StartTranscodeResp {

    @SerializedName("ResponseMetadata")
    private com.bytedance.open.model.ResponseMetadata responseMetadata;
    @SerializedName("Result")
    private StartTranscodeResult result;

    public com.bytedance.open.model.ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

    public void setResponseMetadata(com.bytedance.open.model.ResponseMetadata responseMetadata) {
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
