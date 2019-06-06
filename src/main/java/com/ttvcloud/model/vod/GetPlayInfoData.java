package com.ttvcloud.model.vod;

public class GetPlayInfoData {
    private GetPlayInfoInner Data;

    public GetPlayInfoInner getData() {
        return Data;
    }

    public void setData(GetPlayInfoInner data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "GetPlayInfoData{" +
                "Data=" + Data +
                '}';
    }
}
