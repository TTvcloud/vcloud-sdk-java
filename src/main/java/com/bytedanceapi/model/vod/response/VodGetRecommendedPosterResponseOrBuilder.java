// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod/response/response_vod.proto

package com.bytedanceapi.model.vod.response;

public interface VodGetRecommendedPosterResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Vcloud.Models.Vod.VodGetRecommendedPosterResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
   * @return Whether the responseMetadata field is set.
   */
  boolean hasResponseMetadata();
  /**
   * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
   * @return The responseMetadata.
   */
  com.bytedanceapi.model.base.ResponseMetadata getResponseMetadata();
  /**
   * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
   */
  com.bytedanceapi.model.base.ResponseMetadataOrBuilder getResponseMetadataOrBuilder();

  /**
   * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
   * @return Whether the result field is set.
   */
  boolean hasResult();
  /**
   * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
   * @return The result.
   */
  com.bytedanceapi.model.vod.business.VodGetRecPosterData getResult();
  /**
   * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
   */
  com.bytedanceapi.model.vod.business.VodGetRecPosterDataOrBuilder getResultOrBuilder();
}
