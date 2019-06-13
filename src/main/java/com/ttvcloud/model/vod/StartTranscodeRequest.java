package com.ttvcloud.model.vod;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class StartTranscodeRequest {

    @SerializedName("Vid")
    private String vid;
    @SerializedName("TemplateId")
    private String templateId;
    @SerializedName("Input")
    private Map<String, Object> input;
    @SerializedName("Priority")
    private int priority;

    public StartTranscodeRequest(){
    }

    public StartTranscodeRequest(String vid, String templateId, Map<String, Object> input, int priority) {
        this.vid = vid;
        this.templateId = templateId;
        this.input = input;
        this.priority = priority;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Map<String, Object> getInput() {
        return input;
    }

    public void setInput(Map<String, Object> input) {
        this.input = input;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "StartTranscodeRequest{" +
                "vid='" + vid + '\'' +
                ", templateId='" + templateId + '\'' +
                ", input=" + input +
                ", priority=" + priority +
                '}';
    }
}
