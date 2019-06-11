package com.ttvcloud.model.vod;

import java.util.Map;

public class TranscodeRequestBody {

    private String Vid;
    private Map<String, Object> Input;
    private int Priority;

    public TranscodeRequestBody() {
    }

    public TranscodeRequestBody(String vid, Map<String, Object> input, int priority) {
        Vid = vid;
        Input = input;
        Priority = priority;
    }

    public String getVid() {
        return Vid;
    }

    public void setVid(String vid) {
        Vid = vid;
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
}
