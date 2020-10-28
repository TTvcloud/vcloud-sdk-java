// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod_play.proto

package com.bytedanceapi.model.common;

public interface VodAdaptiveInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ttvcloud.models.VodAdaptiveInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * mpd主链接
   * </pre>
   *
   * <code>string MainPlayUrl = 1;</code>
   * @return The mainPlayUrl.
   */
  java.lang.String getMainPlayUrl();
  /**
   * <pre>
   * mpd主链接
   * </pre>
   *
   * <code>string MainPlayUrl = 1;</code>
   * @return The bytes for mainPlayUrl.
   */
  com.google.protobuf.ByteString
      getMainPlayUrlBytes();

  /**
   * <pre>
   * mpd备用链接
   * </pre>
   *
   * <code>string BackupPlayUrl = 2;</code>
   * @return The backupPlayUrl.
   */
  java.lang.String getBackupPlayUrl();
  /**
   * <pre>
   * mpd备用链接
   * </pre>
   *
   * <code>string BackupPlayUrl = 2;</code>
   * @return The bytes for backupPlayUrl.
   */
  com.google.protobuf.ByteString
      getBackupPlayUrlBytes();

  /**
   * <pre>
   * 动态类型segment_base-mpd,segment_template-dash
   * </pre>
   *
   * <code>string AdaptiveType = 3;</code>
   * @return The adaptiveType.
   */
  java.lang.String getAdaptiveType();
  /**
   * <pre>
   * 动态类型segment_base-mpd,segment_template-dash
   * </pre>
   *
   * <code>string AdaptiveType = 3;</code>
   * @return The bytes for adaptiveType.
   */
  com.google.protobuf.ByteString
      getAdaptiveTypeBytes();
}
