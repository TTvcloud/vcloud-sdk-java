package com.bytedance.open.model.vod;

import com.google.gson.annotations.SerializedName;

public class PlayInfo {

    @SerializedName("Bitrate")
    private int bitrate;
    @SerializedName("FileHash")
    private String fileHash;
    @SerializedName("Size")
    private int size;
    @SerializedName("Height")
    private int height;
    @SerializedName("Width")
    private int width;
    @SerializedName("Format")
    private String format;
    @SerializedName("Codec")
    private String codec;
    @SerializedName("Logo")
    private String logo;
    @SerializedName("Definition")
    private String definition;
    @SerializedName("Quality")
    private String quality;
    @SerializedName("PlayAuth")
    private String playAuth;
    @SerializedName("MainPlayUrl")
    private String mainPlayUrl;
    @SerializedName("BackupPlayUrl")
    private String backupPlayUrl;
    @SerializedName("FileID")
    private String fileID;
    @SerializedName("P2pVerifyURL")
    private String p2pVerifyURL;
    @SerializedName("PreloadInterval")
    private int preloadInterval;
    @SerializedName("PreloadMaxStep")
    private int preloadMaxStep;
    @SerializedName("PreloadMinStep")
    private int preloadMinStep;
    @SerializedName("PreloadSize")
    private int preloadSize;

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getPlayAuth() {
        return playAuth;
    }

    public void setPlayAuth(String playAuth) {
        this.playAuth = playAuth;
    }

    public String getMainPlayUrl() {
        return mainPlayUrl;
    }

    public void setMainPlayUrl(String mainPlayUrl) {
        this.mainPlayUrl = mainPlayUrl;
    }

    public String getBackupPlayUrl() {
        return backupPlayUrl;
    }

    public void setBackupPlayUrl(String backupPlayUrl) {
        this.backupPlayUrl = backupPlayUrl;
    }

    public String getFileID() {
        return fileID;
    }

    public void setFileID(String fileID) {
        this.fileID = fileID;
    }

    public String getP2pVerifyURL() {
        return p2pVerifyURL;
    }

    public void setP2pVerifyURL(String p2pVerifyURL) {
        this.p2pVerifyURL = p2pVerifyURL;
    }

    public int getPreloadInterval() {
        return preloadInterval;
    }

    public void setPreloadInterval(int preloadInterval) {
        this.preloadInterval = preloadInterval;
    }

    public int getPreloadMaxStep() {
        return preloadMaxStep;
    }

    public void setPreloadMaxStep(int preloadMaxStep) {
        this.preloadMaxStep = preloadMaxStep;
    }

    public int getPreloadMinStep() {
        return preloadMinStep;
    }

    public void setPreloadMinStep(int preloadMinStep) {
        this.preloadMinStep = preloadMinStep;
    }

    public int getPreloadSize() {
        return preloadSize;
    }

    public void setPreloadSize(int preloadSize) {
        this.preloadSize = preloadSize;
    }

    @Override
    public String toString() {
        return "PlayInfo{" +
                "bitrate=" + bitrate +
                ", fileHash='" + fileHash + '\'' +
                ", size=" + size +
                ", height=" + height +
                ", width=" + width +
                ", format='" + format + '\'' +
                ", codec='" + codec + '\'' +
                ", logo='" + logo + '\'' +
                ", definition='" + definition + '\'' +
                ", quality='" + quality + '\'' +
                ", playAuth='" + playAuth + '\'' +
                ", mainPlayUrl='" + mainPlayUrl + '\'' +
                ", backupPlayUrl='" + backupPlayUrl + '\'' +
                ", fileID='" + fileID + '\'' +
                ", p2pVerifyURL='" + p2pVerifyURL + '\'' +
                ", preloadInterval=" + preloadInterval +
                ", preloadMaxStep=" + preloadMaxStep +
                ", preloadMinStep=" + preloadMinStep +
                ", preloadSize=" + preloadSize +
                '}';
    }
}
