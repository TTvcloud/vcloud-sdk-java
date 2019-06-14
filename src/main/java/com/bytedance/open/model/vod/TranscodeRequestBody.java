package com.bytedance.open.model.vod;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class TranscodeRequestBody {

    @SerializedName("Vid")
    private String vid;
    @SerializedName("Input")
    private Map<String, Object> input;
    @SerializedName("Priority")
    private int priority;

    public TranscodeRequestBody() {
    }

    public TranscodeRequestBody(String vid, Map<String, Object> input, int priority) {
        this.vid = vid;
        this.input = input;
        this.priority = priority;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
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
        return "TranscodeRequestBody{" +
                "vid='" + vid + '\'' +
                ", input=" + input +
                ", priority=" + priority +
                '}';
    }
}
