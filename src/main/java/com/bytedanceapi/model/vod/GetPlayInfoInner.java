package com.bytedanceapi.model.vod;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class GetPlayInfoInner {
    @SerializedName("Status")
    private int status;
    @SerializedName("VideoID")
    private String videoID;
    @SerializedName("CoverUrl")
    private String coverUrl;
    @SerializedName("Duration")
    private float duration;
    @SerializedName("MediaType")
    private String mediaType;
    @SerializedName("PlayInfoList")
    private PlayInfo[] playInfoList;
    @SerializedName("TotalCount")
    private int totalCount;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public PlayInfo[] getPlayInfoList() {
        return playInfoList;
    }

    public void setPlayInfoList(PlayInfo[] playInfoList) {
        this.playInfoList = playInfoList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "GetPlayInfoInner{" +
                "status=" + status +
                ", videoID='" + videoID + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", duration=" + duration +
                ", mediaType='" + mediaType + '\'' +
                ", playInfoList=" + Arrays.toString(playInfoList) +
                ", totalCount=" + totalCount +
                '}';
    }
}
