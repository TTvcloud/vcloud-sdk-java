package com.bytedanceapi.model.vod;

import com.google.gson.annotations.SerializedName;
import com.bytedanceapi.model.ResponseMetadata;

public class GetPlayInfoResp {
    @SerializedName("ResponseMetadata")
    private ResponseMetadata responseMetadata;
    @SerializedName("Result")
    private GetPlayInfoData result;


    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

    public void setResponseMetadata(ResponseMetadata responseMetadata) {
        this.responseMetadata = responseMetadata;
    }

    public GetPlayInfoData getResult() {
        return result;
    }

    public void setResult(GetPlayInfoData result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "GetPlayInfoResp{" +
                "responseMetadata=" + responseMetadata +
                ", result=" + result +
                '}';
    }
}
