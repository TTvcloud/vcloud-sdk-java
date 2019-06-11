package com.ttvcloud.model.vod;

public class StartTranscodeResult {

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
