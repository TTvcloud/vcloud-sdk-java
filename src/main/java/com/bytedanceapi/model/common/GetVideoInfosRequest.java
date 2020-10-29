// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod_media.proto

package com.bytedanceapi.model.common;

/**
 * Protobuf type {@code Vcloud.Models.Vod.GetVideoInfosRequest}
 */
public final class GetVideoInfosRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Vcloud.Models.Vod.GetVideoInfosRequest)
    GetVideoInfosRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetVideoInfosRequest.newBuilder() to construct.
  private GetVideoInfosRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetVideoInfosRequest() {
    vids_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetVideoInfosRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetVideoInfosRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
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
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              vids_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            vids_.add(s);
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
        vids_ = vids_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.bytedanceapi.model.common.VodMedia.internal_static_Vcloud_Models_Vod_GetVideoInfosRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.bytedanceapi.model.common.VodMedia.internal_static_Vcloud_Models_Vod_GetVideoInfosRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.bytedanceapi.model.common.GetVideoInfosRequest.class, com.bytedanceapi.model.common.GetVideoInfosRequest.Builder.class);
  }

  public static final int VIDS_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList vids_;
  /**
   * <pre>
   *视频ID列表
   * </pre>
   *
   * <code>repeated string Vids = 1;</code>
   * @return A list containing the vids.
   */
  public com.google.protobuf.ProtocolStringList
      getVidsList() {
    return vids_;
  }
  /**
   * <pre>
   *视频ID列表
   * </pre>
   *
   * <code>repeated string Vids = 1;</code>
   * @return The count of vids.
   */
  public int getVidsCount() {
    return vids_.size();
  }
  /**
   * <pre>
   *视频ID列表
   * </pre>
   *
   * <code>repeated string Vids = 1;</code>
   * @param index The index of the element to return.
   * @return The vids at the given index.
   */
  public java.lang.String getVids(int index) {
    return vids_.get(index);
  }
  /**
   * <pre>
   *视频ID列表
   * </pre>
   *
   * <code>repeated string Vids = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the vids at the given index.
   */
  public com.google.protobuf.ByteString
      getVidsBytes(int index) {
    return vids_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < vids_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, vids_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < vids_.size(); i++) {
        dataSize += computeStringSizeNoTag(vids_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getVidsList().size();
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.bytedanceapi.model.common.GetVideoInfosRequest)) {
      return super.equals(obj);
    }
    com.bytedanceapi.model.common.GetVideoInfosRequest other = (com.bytedanceapi.model.common.GetVideoInfosRequest) obj;

    if (!getVidsList()
        .equals(other.getVidsList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getVidsCount() > 0) {
      hash = (37 * hash) + VIDS_FIELD_NUMBER;
      hash = (53 * hash) + getVidsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.bytedanceapi.model.common.GetVideoInfosRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.bytedanceapi.model.common.GetVideoInfosRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.bytedanceapi.model.common.GetVideoInfosRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.bytedanceapi.model.common.GetVideoInfosRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.bytedanceapi.model.common.GetVideoInfosRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.bytedanceapi.model.common.GetVideoInfosRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.bytedanceapi.model.common.GetVideoInfosRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.bytedanceapi.model.common.GetVideoInfosRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.bytedanceapi.model.common.GetVideoInfosRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.bytedanceapi.model.common.GetVideoInfosRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.bytedanceapi.model.common.GetVideoInfosRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.bytedanceapi.model.common.GetVideoInfosRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.bytedanceapi.model.common.GetVideoInfosRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Vcloud.Models.Vod.GetVideoInfosRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Vcloud.Models.Vod.GetVideoInfosRequest)
      com.bytedanceapi.model.common.GetVideoInfosRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.bytedanceapi.model.common.VodMedia.internal_static_Vcloud_Models_Vod_GetVideoInfosRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.bytedanceapi.model.common.VodMedia.internal_static_Vcloud_Models_Vod_GetVideoInfosRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.bytedanceapi.model.common.GetVideoInfosRequest.class, com.bytedanceapi.model.common.GetVideoInfosRequest.Builder.class);
    }

    // Construct using com.bytedanceapi.model.common.GetVideoInfosRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      vids_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.bytedanceapi.model.common.VodMedia.internal_static_Vcloud_Models_Vod_GetVideoInfosRequest_descriptor;
    }

    @java.lang.Override
    public com.bytedanceapi.model.common.GetVideoInfosRequest getDefaultInstanceForType() {
      return com.bytedanceapi.model.common.GetVideoInfosRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.bytedanceapi.model.common.GetVideoInfosRequest build() {
      com.bytedanceapi.model.common.GetVideoInfosRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.bytedanceapi.model.common.GetVideoInfosRequest buildPartial() {
      com.bytedanceapi.model.common.GetVideoInfosRequest result = new com.bytedanceapi.model.common.GetVideoInfosRequest(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        vids_ = vids_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.vids_ = vids_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.bytedanceapi.model.common.GetVideoInfosRequest) {
        return mergeFrom((com.bytedanceapi.model.common.GetVideoInfosRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.bytedanceapi.model.common.GetVideoInfosRequest other) {
      if (other == com.bytedanceapi.model.common.GetVideoInfosRequest.getDefaultInstance()) return this;
      if (!other.vids_.isEmpty()) {
        if (vids_.isEmpty()) {
          vids_ = other.vids_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureVidsIsMutable();
          vids_.addAll(other.vids_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.bytedanceapi.model.common.GetVideoInfosRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.bytedanceapi.model.common.GetVideoInfosRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList vids_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureVidsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        vids_ = new com.google.protobuf.LazyStringArrayList(vids_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <pre>
     *视频ID列表
     * </pre>
     *
     * <code>repeated string Vids = 1;</code>
     * @return A list containing the vids.
     */
    public com.google.protobuf.ProtocolStringList
        getVidsList() {
      return vids_.getUnmodifiableView();
    }
    /**
     * <pre>
     *视频ID列表
     * </pre>
     *
     * <code>repeated string Vids = 1;</code>
     * @return The count of vids.
     */
    public int getVidsCount() {
      return vids_.size();
    }
    /**
     * <pre>
     *视频ID列表
     * </pre>
     *
     * <code>repeated string Vids = 1;</code>
     * @param index The index of the element to return.
     * @return The vids at the given index.
     */
    public java.lang.String getVids(int index) {
      return vids_.get(index);
    }
    /**
     * <pre>
     *视频ID列表
     * </pre>
     *
     * <code>repeated string Vids = 1;</code>
     * @param index The index of the value to return.
     * @return The bytes of the vids at the given index.
     */
    public com.google.protobuf.ByteString
        getVidsBytes(int index) {
      return vids_.getByteString(index);
    }
    /**
     * <pre>
     *视频ID列表
     * </pre>
     *
     * <code>repeated string Vids = 1;</code>
     * @param index The index to set the value at.
     * @param value The vids to set.
     * @return This builder for chaining.
     */
    public Builder setVids(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureVidsIsMutable();
      vids_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *视频ID列表
     * </pre>
     *
     * <code>repeated string Vids = 1;</code>
     * @param value The vids to add.
     * @return This builder for chaining.
     */
    public Builder addVids(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureVidsIsMutable();
      vids_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *视频ID列表
     * </pre>
     *
     * <code>repeated string Vids = 1;</code>
     * @param values The vids to add.
     * @return This builder for chaining.
     */
    public Builder addAllVids(
        java.lang.Iterable<java.lang.String> values) {
      ensureVidsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, vids_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *视频ID列表
     * </pre>
     *
     * <code>repeated string Vids = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearVids() {
      vids_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *视频ID列表
     * </pre>
     *
     * <code>repeated string Vids = 1;</code>
     * @param value The bytes of the vids to add.
     * @return This builder for chaining.
     */
    public Builder addVidsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureVidsIsMutable();
      vids_.add(value);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Vcloud.Models.Vod.GetVideoInfosRequest)
  }

  // @@protoc_insertion_point(class_scope:Vcloud.Models.Vod.GetVideoInfosRequest)
  private static final com.bytedanceapi.model.common.GetVideoInfosRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.bytedanceapi.model.common.GetVideoInfosRequest();
  }

  public static com.bytedanceapi.model.common.GetVideoInfosRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetVideoInfosRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetVideoInfosRequest>() {
    @java.lang.Override
    public GetVideoInfosRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetVideoInfosRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetVideoInfosRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetVideoInfosRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.bytedanceapi.model.common.GetVideoInfosRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

