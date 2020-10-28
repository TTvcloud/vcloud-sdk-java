// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod_media.proto

package com.bytedanceapi.model.common;

public interface VideoInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Vcloud.Models.Vod.VideoInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *视频基础信息
   * </pre>
   *
   * <code>.Vcloud.Models.Vod.BasicInfo BasicInfo = 1;</code>
   * @return Whether the basicInfo field is set.
   */
  boolean hasBasicInfo();
  /**
   * <pre>
   *视频基础信息
   * </pre>
   *
   * <code>.Vcloud.Models.Vod.BasicInfo BasicInfo = 1;</code>
   * @return The basicInfo.
   */
  com.bytedanceapi.model.common.BasicInfo getBasicInfo();
  /**
   * <pre>
   *视频基础信息
   * </pre>
   *
   * <code>.Vcloud.Models.Vod.BasicInfo BasicInfo = 1;</code>
   */
  com.bytedanceapi.model.common.BasicInfoOrBuilder getBasicInfoOrBuilder();

  /**
   * <pre>
   *原视频信息
   * </pre>
   *
   * <code>.Vcloud.Models.Vod.SourceInfo SourceInfo = 2;</code>
   * @return Whether the sourceInfo field is set.
   */
  boolean hasSourceInfo();
  /**
   * <pre>
   *原视频信息
   * </pre>
   *
   * <code>.Vcloud.Models.Vod.SourceInfo SourceInfo = 2;</code>
   * @return The sourceInfo.
   */
  com.bytedanceapi.model.common.SourceInfo getSourceInfo();
  /**
   * <pre>
   *原视频信息
   * </pre>
   *
   * <code>.Vcloud.Models.Vod.SourceInfo SourceInfo = 2;</code>
   */
  com.bytedanceapi.model.common.SourceInfoOrBuilder getSourceInfoOrBuilder();

  /**
   * <pre>
   *转码视频信息列表
   * </pre>
   *
   * <code>repeated .Vcloud.Models.Vod.TranscodeInfo TranscodeInfos = 3;</code>
   */
  java.util.List<com.bytedanceapi.model.common.TranscodeInfo> 
      getTranscodeInfosList();
  /**
   * <pre>
   *转码视频信息列表
   * </pre>
   *
   * <code>repeated .Vcloud.Models.Vod.TranscodeInfo TranscodeInfos = 3;</code>
   */
  com.bytedanceapi.model.common.TranscodeInfo getTranscodeInfos(int index);
  /**
   * <pre>
   *转码视频信息列表
   * </pre>
   *
   * <code>repeated .Vcloud.Models.Vod.TranscodeInfo TranscodeInfos = 3;</code>
   */
  int getTranscodeInfosCount();
  /**
   * <pre>
   *转码视频信息列表
   * </pre>
   *
   * <code>repeated .Vcloud.Models.Vod.TranscodeInfo TranscodeInfos = 3;</code>
   */
  java.util.List<? extends com.bytedanceapi.model.common.TranscodeInfoOrBuilder> 
      getTranscodeInfosOrBuilderList();
  /**
   * <pre>
   *转码视频信息列表
   * </pre>
   *
   * <code>repeated .Vcloud.Models.Vod.TranscodeInfo TranscodeInfos = 3;</code>
   */
  com.bytedanceapi.model.common.TranscodeInfoOrBuilder getTranscodeInfosOrBuilder(
      int index);
}
