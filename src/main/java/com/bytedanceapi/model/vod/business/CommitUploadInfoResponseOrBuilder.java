// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod/business/vod_upload.proto

package com.bytedanceapi.model.vod.business;

public interface CommitUploadInfoResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Vcloud.Models.Vod.CommitUploadInfoResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string Vid = 1;</code>
   * @return The vid.
   */
  java.lang.String getVid();
  /**
   * <code>string Vid = 1;</code>
   * @return The bytes for vid.
   */
  com.google.protobuf.ByteString
      getVidBytes();

  /**
   * <code>.Vcloud.Models.Vod.VodSourceInfo SourceInfo = 2;</code>
   * @return Whether the sourceInfo field is set.
   */
  boolean hasSourceInfo();
  /**
   * <code>.Vcloud.Models.Vod.VodSourceInfo SourceInfo = 2;</code>
   * @return The sourceInfo.
   */
  com.bytedanceapi.model.vod.business.VodSourceInfo getSourceInfo();
  /**
   * <code>.Vcloud.Models.Vod.VodSourceInfo SourceInfo = 2;</code>
   */
  com.bytedanceapi.model.vod.business.VodSourceInfoOrBuilder getSourceInfoOrBuilder();

  /**
   * <code>string PosterUri = 3;</code>
   * @return The posterUri.
   */
  java.lang.String getPosterUri();
  /**
   * <code>string PosterUri = 3;</code>
   * @return The bytes for posterUri.
   */
  com.google.protobuf.ByteString
      getPosterUriBytes();

  /**
   * <code>string CallbackArgs = 4;</code>
   * @return The callbackArgs.
   */
  java.lang.String getCallbackArgs();
  /**
   * <code>string CallbackArgs = 4;</code>
   * @return The bytes for callbackArgs.
   */
  com.google.protobuf.ByteString
      getCallbackArgsBytes();

  /**
   * <code>.Vcloud.Models.Vod.Encryption Encryption = 5;</code>
   * @return Whether the encryption field is set.
   */
  boolean hasEncryption();
  /**
   * <code>.Vcloud.Models.Vod.Encryption Encryption = 5;</code>
   * @return The encryption.
   */
  com.bytedanceapi.model.vod.business.Encryption getEncryption();
  /**
   * <code>.Vcloud.Models.Vod.Encryption Encryption = 5;</code>
   */
  com.bytedanceapi.model.vod.business.EncryptionOrBuilder getEncryptionOrBuilder();
}