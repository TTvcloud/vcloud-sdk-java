package com.ttvcloud.model.vod;

import com.google.gson.annotations.SerializedName;
import com.ttvcloud.model.ResponseMetadata;

public class StartTranscodeResp {

    @SerializedName("ResponseMetadata")
    private ResponseMetadata responseMetadata;
    @SerializedName("Result")
    private StartTranscodeResult result;

    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

    public void setResponseMetadata(ResponseMetadata responseMetadata) {
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
