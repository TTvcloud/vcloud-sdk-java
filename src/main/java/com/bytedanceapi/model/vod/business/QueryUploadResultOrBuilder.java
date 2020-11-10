// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod/business/vod_upload.proto

package com.bytedanceapi.model.vod.business;

public interface QueryUploadResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Vcloud.Models.Vod.QueryUploadResult)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Vcloud.Models.Vod.URLSet VideoInfoList = 1;</code>
   */
  java.util.List<URLSet>
      getVideoInfoListList();
  /**
   * <code>repeated .Vcloud.Models.Vod.URLSet VideoInfoList = 1;</code>
   */
  URLSet getVideoInfoList(int index);
  /**
   * <code>repeated .Vcloud.Models.Vod.URLSet VideoInfoList = 1;</code>
   */
  int getVideoInfoListCount();
  /**
   * <code>repeated .Vcloud.Models.Vod.URLSet VideoInfoList = 1;</code>
   */
  java.util.List<? extends URLSetOrBuilder>
      getVideoInfoListOrBuilderList();
  /**
   * <code>repeated .Vcloud.Models.Vod.URLSet VideoInfoList = 1;</code>
   */
  URLSetOrBuilder getVideoInfoListOrBuilder(
      int index);

  /**
   * <code>repeated string NotExistJobIds = 2;</code>
   * @return A list containing the notExistJobIds.
   */
  java.util.List<java.lang.String>
      getNotExistJobIdsList();
  /**
   * <code>repeated string NotExistJobIds = 2;</code>
   * @return The count of notExistJobIds.
   */
  int getNotExistJobIdsCount();
  /**
   * <code>repeated string NotExistJobIds = 2;</code>
   * @param index The index of the element to return.
   * @return The notExistJobIds at the given index.
   */
  java.lang.String getNotExistJobIds(int index);
  /**
   * <code>repeated string NotExistJobIds = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the notExistJobIds at the given index.
   */
  com.google.protobuf.ByteString
      getNotExistJobIdsBytes(int index);
}
