package com.ttvcloud.model.vod;

import java.util.Arrays;

public class GetPlayInfoInner {
    private int Status;
    private String VideoID;
    private String CoverUrl;
    private float Duration;
    private String MediaType;
    private PlayInfo[] PlayInfoList;
    private int TotalCount;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getVideoID() {
        return VideoID;
    }

    public void setVideoID(String videoID) {
        VideoID = videoID;
    }

    public String getCoverUrl() {
        return CoverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        CoverUrl = coverUrl;
    }

    public float getDuration() {
        return Duration;
    }

    public void setDuration(float duration) {
        Duration = duration;
    }

    public String getMediaType() {
        return MediaType;
    }

    public void setMediaType(String mediaType) {
        MediaType = mediaType;
    }

    public PlayInfo[] getPlayInfoList() {
        return PlayInfoList;
    }

    public void setPlayInfoList(PlayInfo[] playInfoList) {
        PlayInfoList = playInfoList;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int totalCount) {
        TotalCount = totalCount;
    }

    @Override
    public String toString() {
        return "GetPlayInfoInner{" +
                "Status=" + Status +
                ", VideoID='" + VideoID + '\'' +
                ", CoverUrl='" + CoverUrl + '\'' +
                ", Duration=" + Duration +
                ", MediaType='" + MediaType + '\'' +
                ", PlayInfoList=" + Arrays.toString(PlayInfoList) +
                ", TotalCount=" + TotalCount +
                '}';
    }
}
