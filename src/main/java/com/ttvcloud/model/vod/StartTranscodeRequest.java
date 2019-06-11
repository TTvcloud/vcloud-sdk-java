package com.ttvcloud.model.vod;

import java.util.Map;

public class StartTranscodeRequest {

    private String Vid;
    private String TemplateId;
    private Map<String, Object> Input;
    private int Priority;

    public StartTranscodeRequest(){
    }

    public StartTranscodeRequest(String vid, String templateId, Map<String, Object> input, int priority) {
        this.Vid = vid;
        this.TemplateId = templateId;
        this.Input = input;
        this.Priority = priority;
    }

    public String getVid() {
        return Vid;
    }

    public void setVid(String vid) {
        Vid = vid;
    }

    public String getTemplateId() {
        return TemplateId;
    }

    public void setTemplateId(String templateId) {
        TemplateId = templateId;
    }

    public Map<String, Object> getInput() {
        return Input;
    }

    public void setInput(Map<String, Object> input) {
        Input = input;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

    @Override
    public String toString() {
        return "StartTranscodeRequest{" +
                "Vid='" + Vid + '\'' +
                ", TemplateId='" + TemplateId + '\'' +
                ", Input=" + Input +
                ", Priority=" + Priority +
                '}';
    }
}
