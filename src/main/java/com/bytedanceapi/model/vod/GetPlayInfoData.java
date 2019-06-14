package com.bytedanceapi.model.vod;

import com.google.gson.annotations.SerializedName;

public class GetPlayInfoData {

    @SerializedName("Data")
    private GetPlayInfoInner data;

    public GetPlayInfoInner getData() {
        return data;
    }

    public void setData(GetPlayInfoInner data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GetPlayInfoData{" +
                "data=" + data +
                '}';
    }
}
