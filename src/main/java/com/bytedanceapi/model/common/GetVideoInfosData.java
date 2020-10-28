// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod_media.proto

package com.bytedanceapi.model.common;

/**
 * Protobuf type {@code Vcloud.Models.Vod.GetVideoInfosData}
 */
public final class GetVideoInfosData extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Vcloud.Models.Vod.GetVideoInfosData)
    GetVideoInfosDataOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetVideoInfosData.newBuilder() to construct.
  private GetVideoInfosData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetVideoInfosData() {
    videoInfoList_ = java.util.Collections.emptyList();
    notExistVids_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetVideoInfosData();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetVideoInfosData(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              videoInfoList_ = new java.util.ArrayList<com.bytedanceapi.model.common.VideoInfo>();
              mutable_bitField0_ |= 0x00000001;
            }
            videoInfoList_.add(
                input.readMessage(com.bytedanceapi.model.common.VideoInfo.parser(), extensionRegistry));
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000002) != 0)) {
              notExistVids_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000002;
            }
            notExistVids_.add(s);
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        videoInfoList_ = java.util.Collections.unmodifiableList(videoInfoList_);
      }
      if (((mutable_bitField0_ & 0x00000002) != 0)) {
        notExistVids_ = notExistVids_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.bytedanceapi.model.common.VodMedia.internal_static_Vcloud_Models_Vod_GetVideoInfosData_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.bytedanceapi.model.common.VodMedia.internal_static_Vcloud_Models_Vod_GetVideoInfosData_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            GetVideoInfosData.class, Builder.class);
  }

  public static final int VIDEOINFOLIST_FIELD_NUMBER = 1;
  private java.util.List<com.bytedanceapi.model.common.VideoInfo> videoInfoList_;
  /**
   * <pre>
   *视频信息列表
   * </pre>
   *
   * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
   */
  @Override
  public java.util.List<com.bytedanceapi.model.common.VideoInfo> getVideoInfoListList() {
    return videoInfoList_;
  }
  /**
   * <pre>
   *视频信息列表
   * </pre>
   *
   * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
   */
  @Override
  public java.util.List<? extends com.bytedanceapi.model.common.VideoInfoOrBuilder> 
      getVideoInfoListOrBuilderList() {
    return videoInfoList_;
  }
  /**
   * <pre>
   *视频信息列表
   * </pre>
   *
   * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
   */
  @Override
  public int getVideoInfoListCount() {
    return videoInfoList_.size();
  }
  /**
   * <pre>
   *视频信息列表
   * </pre>
   *
   * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
   */
  @Override
  public com.bytedanceapi.model.common.VideoInfo getVideoInfoList(int index) {
    return videoInfoList_.get(index);
  }
  /**
   * <pre>
   *视频信息列表
   * </pre>
   *
   * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
   */
  @Override
  public com.bytedanceapi.model.common.VideoInfoOrBuilder getVideoInfoListOrBuilder(
      int index) {
    return videoInfoList_.get(index);
  }

  public static final int NOTEXISTVIDS_FIELD_NUMBER = 2;
  private com.google.protobuf.LazyStringList notExistVids_;
  /**
   * <pre>
   *不存在的视频VID列表
   * </pre>
   *
   * <code>repeated string NotExistVids = 2;</code>
   * @return A list containing the notExistVids.
   */
  public com.google.protobuf.ProtocolStringList
      getNotExistVidsList() {
    return notExistVids_;
  }
  /**
   * <pre>
   *不存在的视频VID列表
   * </pre>
   *
   * <code>repeated string NotExistVids = 2;</code>
   * @return The count of notExistVids.
   */
  public int getNotExistVidsCount() {
    return notExistVids_.size();
  }
  /**
   * <pre>
   *不存在的视频VID列表
   * </pre>
   *
   * <code>repeated string NotExistVids = 2;</code>
   * @param index The index of the element to return.
   * @return The notExistVids at the given index.
   */
  public String getNotExistVids(int index) {
    return notExistVids_.get(index);
  }
  /**
   * <pre>
   *不存在的视频VID列表
   * </pre>
   *
   * <code>repeated string NotExistVids = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the notExistVids at the given index.
   */
  public com.google.protobuf.ByteString
      getNotExistVidsBytes(int index) {
    return notExistVids_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < videoInfoList_.size(); i++) {
      output.writeMessage(1, videoInfoList_.get(i));
    }
    for (int i = 0; i < notExistVids_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, notExistVids_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < videoInfoList_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, videoInfoList_.get(i));
    }
    {
      int dataSize = 0;
      for (int i = 0; i < notExistVids_.size(); i++) {
        dataSize += computeStringSizeNoTag(notExistVids_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getNotExistVidsList().size();
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof GetVideoInfosData)) {
      return super.equals(obj);
    }
    GetVideoInfosData other = (GetVideoInfosData) obj;

    if (!getVideoInfoListList()
        .equals(other.getVideoInfoListList())) return false;
    if (!getNotExistVidsList()
        .equals(other.getNotExistVidsList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getVideoInfoListCount() > 0) {
      hash = (37 * hash) + VIDEOINFOLIST_FIELD_NUMBER;
      hash = (53 * hash) + getVideoInfoListList().hashCode();
    }
    if (getNotExistVidsCount() > 0) {
      hash = (37 * hash) + NOTEXISTVIDS_FIELD_NUMBER;
      hash = (53 * hash) + getNotExistVidsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static GetVideoInfosData parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetVideoInfosData parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetVideoInfosData parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetVideoInfosData parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetVideoInfosData parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetVideoInfosData parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetVideoInfosData parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetVideoInfosData parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetVideoInfosData parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static GetVideoInfosData parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetVideoInfosData parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetVideoInfosData parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(GetVideoInfosData prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Vcloud.Models.Vod.GetVideoInfosData}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Vcloud.Models.Vod.GetVideoInfosData)
      GetVideoInfosDataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.bytedanceapi.model.common.VodMedia.internal_static_Vcloud_Models_Vod_GetVideoInfosData_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.bytedanceapi.model.common.VodMedia.internal_static_Vcloud_Models_Vod_GetVideoInfosData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GetVideoInfosData.class, Builder.class);
    }

    // Construct using com.bytedanceapi.model.common.GetVideoInfosData.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getVideoInfoListFieldBuilder();
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      if (videoInfoListBuilder_ == null) {
        videoInfoList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        videoInfoListBuilder_.clear();
      }
      notExistVids_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.bytedanceapi.model.common.VodMedia.internal_static_Vcloud_Models_Vod_GetVideoInfosData_descriptor;
    }

    @Override
    public GetVideoInfosData getDefaultInstanceForType() {
      return GetVideoInfosData.getDefaultInstance();
    }

    @Override
    public GetVideoInfosData build() {
      GetVideoInfosData result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public GetVideoInfosData buildPartial() {
      GetVideoInfosData result = new GetVideoInfosData(this);
      int from_bitField0_ = bitField0_;
      if (videoInfoListBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          videoInfoList_ = java.util.Collections.unmodifiableList(videoInfoList_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.videoInfoList_ = videoInfoList_;
      } else {
        result.videoInfoList_ = videoInfoListBuilder_.build();
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        notExistVids_ = notExistVids_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.notExistVids_ = notExistVids_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof GetVideoInfosData) {
        return mergeFrom((GetVideoInfosData)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(GetVideoInfosData other) {
      if (other == GetVideoInfosData.getDefaultInstance()) return this;
      if (videoInfoListBuilder_ == null) {
        if (!other.videoInfoList_.isEmpty()) {
          if (videoInfoList_.isEmpty()) {
            videoInfoList_ = other.videoInfoList_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureVideoInfoListIsMutable();
            videoInfoList_.addAll(other.videoInfoList_);
          }
          onChanged();
        }
      } else {
        if (!other.videoInfoList_.isEmpty()) {
          if (videoInfoListBuilder_.isEmpty()) {
            videoInfoListBuilder_.dispose();
            videoInfoListBuilder_ = null;
            videoInfoList_ = other.videoInfoList_;
            bitField0_ = (bitField0_ & ~0x00000001);
            videoInfoListBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getVideoInfoListFieldBuilder() : null;
          } else {
            videoInfoListBuilder_.addAllMessages(other.videoInfoList_);
          }
        }
      }
      if (!other.notExistVids_.isEmpty()) {
        if (notExistVids_.isEmpty()) {
          notExistVids_ = other.notExistVids_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureNotExistVidsIsMutable();
          notExistVids_.addAll(other.notExistVids_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      GetVideoInfosData parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (GetVideoInfosData) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.bytedanceapi.model.common.VideoInfo> videoInfoList_ =
      java.util.Collections.emptyList();
    private void ensureVideoInfoListIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        videoInfoList_ = new java.util.ArrayList<com.bytedanceapi.model.common.VideoInfo>(videoInfoList_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.bytedanceapi.model.common.VideoInfo, com.bytedanceapi.model.common.VideoInfo.Builder, com.bytedanceapi.model.common.VideoInfoOrBuilder> videoInfoListBuilder_;

    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public java.util.List<com.bytedanceapi.model.common.VideoInfo> getVideoInfoListList() {
      if (videoInfoListBuilder_ == null) {
        return java.util.Collections.unmodifiableList(videoInfoList_);
      } else {
        return videoInfoListBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public int getVideoInfoListCount() {
      if (videoInfoListBuilder_ == null) {
        return videoInfoList_.size();
      } else {
        return videoInfoListBuilder_.getCount();
      }
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public com.bytedanceapi.model.common.VideoInfo getVideoInfoList(int index) {
      if (videoInfoListBuilder_ == null) {
        return videoInfoList_.get(index);
      } else {
        return videoInfoListBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public Builder setVideoInfoList(
        int index, com.bytedanceapi.model.common.VideoInfo value) {
      if (videoInfoListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureVideoInfoListIsMutable();
        videoInfoList_.set(index, value);
        onChanged();
      } else {
        videoInfoListBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public Builder setVideoInfoList(
        int index, com.bytedanceapi.model.common.VideoInfo.Builder builderForValue) {
      if (videoInfoListBuilder_ == null) {
        ensureVideoInfoListIsMutable();
        videoInfoList_.set(index, builderForValue.build());
        onChanged();
      } else {
        videoInfoListBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public Builder addVideoInfoList(com.bytedanceapi.model.common.VideoInfo value) {
      if (videoInfoListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureVideoInfoListIsMutable();
        videoInfoList_.add(value);
        onChanged();
      } else {
        videoInfoListBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public Builder addVideoInfoList(
        int index, com.bytedanceapi.model.common.VideoInfo value) {
      if (videoInfoListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureVideoInfoListIsMutable();
        videoInfoList_.add(index, value);
        onChanged();
      } else {
        videoInfoListBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public Builder addVideoInfoList(
        com.bytedanceapi.model.common.VideoInfo.Builder builderForValue) {
      if (videoInfoListBuilder_ == null) {
        ensureVideoInfoListIsMutable();
        videoInfoList_.add(builderForValue.build());
        onChanged();
      } else {
        videoInfoListBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public Builder addVideoInfoList(
        int index, com.bytedanceapi.model.common.VideoInfo.Builder builderForValue) {
      if (videoInfoListBuilder_ == null) {
        ensureVideoInfoListIsMutable();
        videoInfoList_.add(index, builderForValue.build());
        onChanged();
      } else {
        videoInfoListBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public Builder addAllVideoInfoList(
        Iterable<? extends com.bytedanceapi.model.common.VideoInfo> values) {
      if (videoInfoListBuilder_ == null) {
        ensureVideoInfoListIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, videoInfoList_);
        onChanged();
      } else {
        videoInfoListBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public Builder clearVideoInfoList() {
      if (videoInfoListBuilder_ == null) {
        videoInfoList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        videoInfoListBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public Builder removeVideoInfoList(int index) {
      if (videoInfoListBuilder_ == null) {
        ensureVideoInfoListIsMutable();
        videoInfoList_.remove(index);
        onChanged();
      } else {
        videoInfoListBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public com.bytedanceapi.model.common.VideoInfo.Builder getVideoInfoListBuilder(
        int index) {
      return getVideoInfoListFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public com.bytedanceapi.model.common.VideoInfoOrBuilder getVideoInfoListOrBuilder(
        int index) {
      if (videoInfoListBuilder_ == null) {
        return videoInfoList_.get(index);  } else {
        return videoInfoListBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public java.util.List<? extends com.bytedanceapi.model.common.VideoInfoOrBuilder> 
         getVideoInfoListOrBuilderList() {
      if (videoInfoListBuilder_ != null) {
        return videoInfoListBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(videoInfoList_);
      }
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public com.bytedanceapi.model.common.VideoInfo.Builder addVideoInfoListBuilder() {
      return getVideoInfoListFieldBuilder().addBuilder(
          com.bytedanceapi.model.common.VideoInfo.getDefaultInstance());
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public com.bytedanceapi.model.common.VideoInfo.Builder addVideoInfoListBuilder(
        int index) {
      return getVideoInfoListFieldBuilder().addBuilder(
          index, com.bytedanceapi.model.common.VideoInfo.getDefaultInstance());
    }
    /**
     * <pre>
     *视频信息列表
     * </pre>
     *
     * <code>repeated .Vcloud.Models.Vod.VideoInfo VideoInfoList = 1;</code>
     */
    public java.util.List<com.bytedanceapi.model.common.VideoInfo.Builder> 
         getVideoInfoListBuilderList() {
      return getVideoInfoListFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.bytedanceapi.model.common.VideoInfo, com.bytedanceapi.model.common.VideoInfo.Builder, com.bytedanceapi.model.common.VideoInfoOrBuilder> 
        getVideoInfoListFieldBuilder() {
      if (videoInfoListBuilder_ == null) {
        videoInfoListBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.bytedanceapi.model.common.VideoInfo, com.bytedanceapi.model.common.VideoInfo.Builder, com.bytedanceapi.model.common.VideoInfoOrBuilder>(
                videoInfoList_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        videoInfoList_ = null;
      }
      return videoInfoListBuilder_;
    }

    private com.google.protobuf.LazyStringList notExistVids_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureNotExistVidsIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        notExistVids_ = new com.google.protobuf.LazyStringArrayList(notExistVids_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <pre>
     *不存在的视频VID列表
     * </pre>
     *
     * <code>repeated string NotExistVids = 2;</code>
     * @return A list containing the notExistVids.
     */
    public com.google.protobuf.ProtocolStringList
        getNotExistVidsList() {
      return notExistVids_.getUnmodifiableView();
    }
    /**
     * <pre>
     *不存在的视频VID列表
     * </pre>
     *
     * <code>repeated string NotExistVids = 2;</code>
     * @return The count of notExistVids.
     */
    public int getNotExistVidsCount() {
      return notExistVids_.size();
    }
    /**
     * <pre>
     *不存在的视频VID列表
     * </pre>
     *
     * <code>repeated string NotExistVids = 2;</code>
     * @param index The index of the element to return.
     * @return The notExistVids at the given index.
     */
    public String getNotExistVids(int index) {
      return notExistVids_.get(index);
    }
    /**
     * <pre>
     *不存在的视频VID列表
     * </pre>
     *
     * <code>repeated string NotExistVids = 2;</code>
     * @param index The index of the value to return.
     * @return The bytes of the notExistVids at the given index.
     */
    public com.google.protobuf.ByteString
        getNotExistVidsBytes(int index) {
      return notExistVids_.getByteString(index);
    }
    /**
     * <pre>
     *不存在的视频VID列表
     * </pre>
     *
     * <code>repeated string NotExistVids = 2;</code>
     * @param index The index to set the value at.
     * @param value The notExistVids to set.
     * @return This builder for chaining.
     */
    public Builder setNotExistVids(
        int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureNotExistVidsIsMutable();
      notExistVids_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *不存在的视频VID列表
     * </pre>
     *
     * <code>repeated string NotExistVids = 2;</code>
     * @param value The notExistVids to add.
     * @return This builder for chaining.
     */
    public Builder addNotExistVids(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureNotExistVidsIsMutable();
      notExistVids_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *不存在的视频VID列表
     * </pre>
     *
     * <code>repeated string NotExistVids = 2;</code>
     * @param values The notExistVids to add.
     * @return This builder for chaining.
     */
    public Builder addAllNotExistVids(
        Iterable<String> values) {
      ensureNotExistVidsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, notExistVids_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *不存在的视频VID列表
     * </pre>
     *
     * <code>repeated string NotExistVids = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearNotExistVids() {
      notExistVids_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *不存在的视频VID列表
     * </pre>
     *
     * <code>repeated string NotExistVids = 2;</code>
     * @param value The bytes of the notExistVids to add.
     * @return This builder for chaining.
     */
    public Builder addNotExistVidsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureNotExistVidsIsMutable();
      notExistVids_.add(value);
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Vcloud.Models.Vod.GetVideoInfosData)
  }

  // @@protoc_insertion_point(class_scope:Vcloud.Models.Vod.GetVideoInfosData)
  private static final GetVideoInfosData DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GetVideoInfosData();
  }

  public static GetVideoInfosData getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetVideoInfosData>
      PARSER = new com.google.protobuf.AbstractParser<GetVideoInfosData>() {
    @Override
    public GetVideoInfosData parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetVideoInfosData(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetVideoInfosData> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<GetVideoInfosData> getParserForType() {
    return PARSER;
  }

  @Override
  public GetVideoInfosData getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

