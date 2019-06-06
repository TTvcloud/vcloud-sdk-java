package com.ttvcloud.model.vod;

import com.ttvcloud.model.ResponseMetadata;

public class GetPlayInfoResp {
    private ResponseMetadata ResponseMetadata;
    private GetPlayInfoData Result;


    public com.ttvcloud.model.ResponseMetadata getResponseMetadata() {
        return ResponseMetadata;
    }

    public void setResponseMetadata(com.ttvcloud.model.ResponseMetadata responseMetadata) {
        ResponseMetadata = responseMetadata;
    }

    public GetPlayInfoData getResult() {
        return Result;
    }

    public void setResult(GetPlayInfoData result) {
        Result = result;
    }

    @Override
    public String toString() {
        return "GetPlayInfoResp{" +
                "ResponseMetadata=" + ResponseMetadata +
                ", Result=" + Result +
                '}';
    }
}
