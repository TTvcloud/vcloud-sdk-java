package com.ttvcloud.model.vod;

import com.ttvcloud.model.ResponseMetadata;

public class StartTranscodeResp {

    private ResponseMetadata ResponseMetadata;
    private StartTranscodeResult Result;

    public com.ttvcloud.model.ResponseMetadata getResponseMetadata() {
        return ResponseMetadata;
    }

    public void setResponseMetadata(com.ttvcloud.model.ResponseMetadata responseMetadata) {
        ResponseMetadata = responseMetadata;
    }

    public StartTranscodeResult getResult() {
        return Result;
    }

    public void setResult(StartTranscodeResult result) {
        Result = result;
    }

    @Override
    public String toString() {
        return "StartTranscodeResp{" +
                "ResponseMetadata=" + ResponseMetadata +
                ", Result=" + Result +
                '}';
    }
}
