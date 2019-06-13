package com.ttvcloud.model.vod;

import com.google.gson.annotations.SerializedName;

public class StartTranscodeResult {

    @SerializedName("RunId")
    private String RunId;

    public String getRunId() {
        return RunId;
    }

    public void setRunId(String runId) {
        RunId = runId;
    }

    @Override
    public String toString() {
        return "StartTranscodeResult{" +
                "RunId='" + RunId + '\'' +
                '}';
    }
}
