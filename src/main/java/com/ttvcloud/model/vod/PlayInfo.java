package com.ttvcloud.model.vod;

public class PlayInfo {

    private int Bitrate;
    private String FileHash;
    private int Size;
    private int Height;
    private int Width;
    private String Format;
    private String Codec;
    private String Logo;
    private String Definition;
    private String Quality;
    private String PlayAuth;
    private String MainPlayUrl;
    private String BackupPlayUrl;
    private String FileID;
    private String P2pVerifyURL;
    private int PreloadInterval;
    private int PreloadMaxStep;
    private int PreloadMinStep;
    private int PreloadSize;

    public int getBitrate() {
        return Bitrate;
    }

    public void setBitrate(int bitrate) {
        Bitrate = bitrate;
    }

    public String getFileHash() {
        return FileHash;
    }

    public void setFileHash(String fileHash) {
        FileHash = fileHash;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getCodec() {
        return Codec;
    }

    public void setCodec(String codec) {
        Codec = codec;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public String getDefinition() {
        return Definition;
    }

    public void setDefinition(String definition) {
        Definition = definition;
    }

    public String getQuality() {
        return Quality;
    }

    public void setQuality(String quality) {
        Quality = quality;
    }

    public String getPlayAuth() {
        return PlayAuth;
    }

    public void setPlayAuth(String playAuth) {
        PlayAuth = playAuth;
    }

    public String getMainPlayUrl() {
        return MainPlayUrl;
    }

    public void setMainPlayUrl(String mainPlayUrl) {
        MainPlayUrl = mainPlayUrl;
    }

    public String getBackupPlayUrl() {
        return BackupPlayUrl;
    }

    public void setBackupPlayUrl(String backupPlayUrl) {
        BackupPlayUrl = backupPlayUrl;
    }

    public String getFileID() {
        return FileID;
    }

    public void setFileID(String fileID) {
        FileID = fileID;
    }

    public String getP2pVerifyURL() {
        return P2pVerifyURL;
    }

    public void setP2pVerifyURL(String p2pVerifyURL) {
        P2pVerifyURL = p2pVerifyURL;
    }

    public int getPreloadInterval() {
        return PreloadInterval;
    }

    public void setPreloadInterval(int preloadInterval) {
        PreloadInterval = preloadInterval;
    }

    public int getPreloadMaxStep() {
        return PreloadMaxStep;
    }

    public void setPreloadMaxStep(int preloadMaxStep) {
        PreloadMaxStep = preloadMaxStep;
    }

    public int getPreloadMinStep() {
        return PreloadMinStep;
    }

    public void setPreloadMinStep(int preloadMinStep) {
        PreloadMinStep = preloadMinStep;
    }

    public int getPreloadSize() {
        return PreloadSize;
    }

    public void setPreloadSize(int preloadSize) {
        PreloadSize = preloadSize;
    }

    @Override
    public String toString() {
        return "PlayInfo{" +
                "Bitrate=" + Bitrate +
                ", FileHash='" + FileHash + '\'' +
                ", Size=" + Size +
                ", Height=" + Height +
                ", Width=" + Width +
                ", Format='" + Format + '\'' +
                ", Codec='" + Codec + '\'' +
                ", Logo='" + Logo + '\'' +
                ", Definition='" + Definition + '\'' +
                ", Quality='" + Quality + '\'' +
                ", PlayAuth='" + PlayAuth + '\'' +
                ", MainPlayUrl='" + MainPlayUrl + '\'' +
                ", BackupPlayUrl='" + BackupPlayUrl + '\'' +
                ", FileID='" + FileID + '\'' +
                ", P2pVerifyURL='" + P2pVerifyURL + '\'' +
                ", PreloadInterval=" + PreloadInterval +
                ", PreloadMaxStep=" + PreloadMaxStep +
                ", PreloadMinStep=" + PreloadMinStep +
                ", PreloadSize=" + PreloadSize +
                '}';
    }
}
