// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod_media.proto

package com.bytedanceapi.model.common;

public interface BasicInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Vcloud.Models.Vod.BasicInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *空间名
   * </pre>
   *
   * <code>string SpaceName = 1;</code>
   * @return The spaceName.
   */
  String getSpaceName();
  /**
   * <pre>
   *空间名
   * </pre>
   *
   * <code>string SpaceName = 1;</code>
   * @return The bytes for spaceName.
   */
  com.google.protobuf.ByteString
      getSpaceNameBytes();

  /**
   * <pre>
   *视频ID
   * </pre>
   *
   * <code>string Vid = 2;</code>
   * @return The vid.
   */
  String getVid();
  /**
   * <pre>
   *视频ID
   * </pre>
   *
   * <code>string Vid = 2;</code>
   * @return The bytes for vid.
   */
  com.google.protobuf.ByteString
      getVidBytes();

  /**
   * <pre>
   *视频名称
   * </pre>
   *
   * <code>string Title = 3;</code>
   * @return The title.
   */
  String getTitle();
  /**
   * <pre>
   *视频名称
   * </pre>
   *
   * <code>string Title = 3;</code>
   * @return The bytes for title.
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <pre>
   *视频描述
   * </pre>
   *
   * <code>string Description = 4;</code>
   * @return The description.
   */
  String getDescription();
  /**
   * <pre>
   *视频描述
   * </pre>
   *
   * <code>string Description = 4;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <pre>
   *封面图对象地址
   * </pre>
   *
   * <code>string PosterUri = 5;</code>
   * @return The posterUri.
   */
  String getPosterUri();
  /**
   * <pre>
   *封面图对象地址
   * </pre>
   *
   * <code>string PosterUri = 5;</code>
   * @return The bytes for posterUri.
   */
  com.google.protobuf.ByteString
      getPosterUriBytes();

  /**
   * <pre>
   *发布状态
   * </pre>
   *
   * <code>string PublishStatus = 6;</code>
   * @return The publishStatus.
   */
  String getPublishStatus();
  /**
   * <pre>
   *发布状态
   * </pre>
   *
   * <code>string PublishStatus = 6;</code>
   * @return The bytes for publishStatus.
   */
  com.google.protobuf.ByteString
      getPublishStatusBytes();

  /**
   * <pre>
   *审核状态
   * </pre>
   *
   * <code>int64 AuditStatus = 7;</code>
   * @return The auditStatus.
   */
  long getAuditStatus();

  /**
   * <pre>
   *标签列表
   * </pre>
   *
   * <code>repeated string Tags = 8;</code>
   * @return A list containing the tags.
   */
  java.util.List<String>
      getTagsList();
  /**
   * <pre>
   *标签列表
   * </pre>
   *
   * <code>repeated string Tags = 8;</code>
   * @return The count of tags.
   */
  int getTagsCount();
  /**
   * <pre>
   *标签列表
   * </pre>
   *
   * <code>repeated string Tags = 8;</code>
   * @param index The index of the element to return.
   * @return The tags at the given index.
   */
  String getTags(int index);
  /**
   * <pre>
   *标签列表
   * </pre>
   *
   * <code>repeated string Tags = 8;</code>
   * @param index The index of the value to return.
   * @return The bytes of the tags at the given index.
   */
  com.google.protobuf.ByteString
      getTagsBytes(int index);

  /**
   * <pre>
   *创建时间
   * </pre>
   *
   * <code>string CreateTime = 9;</code>
   * @return The createTime.
   */
  String getCreateTime();
  /**
   * <pre>
   *创建时间
   * </pre>
   *
   * <code>string CreateTime = 9;</code>
   * @return The bytes for createTime.
   */
  com.google.protobuf.ByteString
      getCreateTimeBytes();
}
