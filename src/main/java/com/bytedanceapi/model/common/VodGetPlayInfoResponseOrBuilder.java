// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod_play.proto

package com.bytedanceapi.model.common;

public interface VodGetPlayInfoResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Vcloud.Models.Vod.VodGetPlayInfoResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 响应通用信息
   * </pre>
   *
   * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
   * @return Whether the responseMetadata field is set.
   */
  boolean hasResponseMetadata();
  /**
   * <pre>
   * 响应通用信息
   * </pre>
   *
   * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
   * @return The responseMetadata.
   */
  com.bytedanceapi.model.common.ResponseMetadata getResponseMetadata();
  /**
   * <pre>
   * 响应通用信息
   * </pre>
   *
   * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
   */
  com.bytedanceapi.model.common.ResponseMetadataOrBuilder getResponseMetadataOrBuilder();

  /**
   * <pre>
   * 响应结果
   * </pre>
   *
   * <code>.Vcloud.Models.Vod.VodGetPlayInfoResult Result = 2;</code>
   * @return Whether the result field is set.
   */
  boolean hasResult();
  /**
   * <pre>
   * 响应结果
   * </pre>
   *
   * <code>.Vcloud.Models.Vod.VodGetPlayInfoResult Result = 2;</code>
   * @return The result.
   */
  com.bytedanceapi.model.common.VodGetPlayInfoResult getResult();
  /**
   * <pre>
   * 响应结果
   * </pre>
   *
   * <code>.Vcloud.Models.Vod.VodGetPlayInfoResult Result = 2;</code>
   */
  com.bytedanceapi.model.common.VodGetPlayInfoResultOrBuilder getResultOrBuilder();
}
