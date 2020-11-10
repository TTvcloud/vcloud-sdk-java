// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod/business/vod_workflow.proto

package com.bytedanceapi.model.vod.business;

/**
 * Protobuf type {@code Vcloud.Models.Vod.TranscodeAudioOverride}
 */
public final class TranscodeAudioOverride extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Vcloud.Models.Vod.TranscodeAudioOverride)
    TranscodeAudioOverrideOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TranscodeAudioOverride.newBuilder() to construct.
  private TranscodeAudioOverride(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TranscodeAudioOverride() {
    templateId_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TranscodeAudioOverride();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TranscodeAudioOverride(
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
              templateId_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            templateId_.add(s);
            break;
          }
          case 18: {
            Clip.Builder subBuilder = null;
            if (clip_ != null) {
              subBuilder = clip_.toBuilder();
            }
            clip_ = input.readMessage(Clip.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(clip_);
              clip_ = subBuilder.buildPartial();
            }

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
        templateId_ = templateId_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return VodWorkflow.internal_static_Vcloud_Models_Vod_TranscodeAudioOverride_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return VodWorkflow.internal_static_Vcloud_Models_Vod_TranscodeAudioOverride_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            TranscodeAudioOverride.class, Builder.class);
  }

  public static final int TEMPLATEID_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList templateId_;
  /**
   * <pre>
   * 被覆盖的音频模板Id, 支持ALL
   * </pre>
   *
   * <code>repeated string TemplateId = 1;</code>
   * @return A list containing the templateId.
   */
  public com.google.protobuf.ProtocolStringList
      getTemplateIdList() {
    return templateId_;
  }
  /**
   * <pre>
   * 被覆盖的音频模板Id, 支持ALL
   * </pre>
   *
   * <code>repeated string TemplateId = 1;</code>
   * @return The count of templateId.
   */
  public int getTemplateIdCount() {
    return templateId_.size();
  }
  /**
   * <pre>
   * 被覆盖的音频模板Id, 支持ALL
   * </pre>
   *
   * <code>repeated string TemplateId = 1;</code>
   * @param index The index of the element to return.
   * @return The templateId at the given index.
   */
  public java.lang.String getTemplateId(int index) {
    return templateId_.get(index);
  }
  /**
   * <pre>
   * 被覆盖的音频模板Id, 支持ALL
   * </pre>
   *
   * <code>repeated string TemplateId = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the templateId at the given index.
   */
  public com.google.protobuf.ByteString
      getTemplateIdBytes(int index) {
    return templateId_.getByteString(index);
  }

  public static final int CLIP_FIELD_NUMBER = 2;
  private Clip clip_;
  /**
   * <code>.Vcloud.Models.Vod.Clip Clip = 2;</code>
   * @return Whether the clip field is set.
   */
  @java.lang.Override
  public boolean hasClip() {
    return clip_ != null;
  }
  /**
   * <code>.Vcloud.Models.Vod.Clip Clip = 2;</code>
   * @return The clip.
   */
  @java.lang.Override
  public Clip getClip() {
    return clip_ == null ? Clip.getDefaultInstance() : clip_;
  }
  /**
   * <code>.Vcloud.Models.Vod.Clip Clip = 2;</code>
   */
  @java.lang.Override
  public ClipOrBuilder getClipOrBuilder() {
    return getClip();
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
    for (int i = 0; i < templateId_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, templateId_.getRaw(i));
    }
    if (clip_ != null) {
      output.writeMessage(2, getClip());
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
      for (int i = 0; i < templateId_.size(); i++) {
        dataSize += computeStringSizeNoTag(templateId_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getTemplateIdList().size();
    }
    if (clip_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getClip());
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
    if (!(obj instanceof TranscodeAudioOverride)) {
      return super.equals(obj);
    }
    TranscodeAudioOverride other = (TranscodeAudioOverride) obj;

    if (!getTemplateIdList()
        .equals(other.getTemplateIdList())) return false;
    if (hasClip() != other.hasClip()) return false;
    if (hasClip()) {
      if (!getClip()
          .equals(other.getClip())) return false;
    }
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
    if (getTemplateIdCount() > 0) {
      hash = (37 * hash) + TEMPLATEID_FIELD_NUMBER;
      hash = (53 * hash) + getTemplateIdList().hashCode();
    }
    if (hasClip()) {
      hash = (37 * hash) + CLIP_FIELD_NUMBER;
      hash = (53 * hash) + getClip().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static TranscodeAudioOverride parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static TranscodeAudioOverride parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static TranscodeAudioOverride parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static TranscodeAudioOverride parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static TranscodeAudioOverride parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static TranscodeAudioOverride parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static TranscodeAudioOverride parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static TranscodeAudioOverride parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static TranscodeAudioOverride parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static TranscodeAudioOverride parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static TranscodeAudioOverride parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static TranscodeAudioOverride parseFrom(
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
  public static Builder newBuilder(TranscodeAudioOverride prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Vcloud.Models.Vod.TranscodeAudioOverride}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Vcloud.Models.Vod.TranscodeAudioOverride)
      TranscodeAudioOverrideOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return VodWorkflow.internal_static_Vcloud_Models_Vod_TranscodeAudioOverride_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return VodWorkflow.internal_static_Vcloud_Models_Vod_TranscodeAudioOverride_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              TranscodeAudioOverride.class, Builder.class);
    }

    // Construct using com.bytedanceapi.model.vod.business.TranscodeAudioOverride.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      templateId_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      if (clipBuilder_ == null) {
        clip_ = null;
      } else {
        clip_ = null;
        clipBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return VodWorkflow.internal_static_Vcloud_Models_Vod_TranscodeAudioOverride_descriptor;
    }

    @java.lang.Override
    public TranscodeAudioOverride getDefaultInstanceForType() {
      return TranscodeAudioOverride.getDefaultInstance();
    }

    @java.lang.Override
    public TranscodeAudioOverride build() {
      TranscodeAudioOverride result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public TranscodeAudioOverride buildPartial() {
      TranscodeAudioOverride result = new TranscodeAudioOverride(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        templateId_ = templateId_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.templateId_ = templateId_;
      if (clipBuilder_ == null) {
        result.clip_ = clip_;
      } else {
        result.clip_ = clipBuilder_.build();
      }
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
      if (other instanceof TranscodeAudioOverride) {
        return mergeFrom((TranscodeAudioOverride)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(TranscodeAudioOverride other) {
      if (other == TranscodeAudioOverride.getDefaultInstance()) return this;
      if (!other.templateId_.isEmpty()) {
        if (templateId_.isEmpty()) {
          templateId_ = other.templateId_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureTemplateIdIsMutable();
          templateId_.addAll(other.templateId_);
        }
        onChanged();
      }
      if (other.hasClip()) {
        mergeClip(other.getClip());
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
      TranscodeAudioOverride parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (TranscodeAudioOverride) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList templateId_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureTemplateIdIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        templateId_ = new com.google.protobuf.LazyStringArrayList(templateId_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <pre>
     * 被覆盖的音频模板Id, 支持ALL
     * </pre>
     *
     * <code>repeated string TemplateId = 1;</code>
     * @return A list containing the templateId.
     */
    public com.google.protobuf.ProtocolStringList
        getTemplateIdList() {
      return templateId_.getUnmodifiableView();
    }
    /**
     * <pre>
     * 被覆盖的音频模板Id, 支持ALL
     * </pre>
     *
     * <code>repeated string TemplateId = 1;</code>
     * @return The count of templateId.
     */
    public int getTemplateIdCount() {
      return templateId_.size();
    }
    /**
     * <pre>
     * 被覆盖的音频模板Id, 支持ALL
     * </pre>
     *
     * <code>repeated string TemplateId = 1;</code>
     * @param index The index of the element to return.
     * @return The templateId at the given index.
     */
    public java.lang.String getTemplateId(int index) {
      return templateId_.get(index);
    }
    /**
     * <pre>
     * 被覆盖的音频模板Id, 支持ALL
     * </pre>
     *
     * <code>repeated string TemplateId = 1;</code>
     * @param index The index of the value to return.
     * @return The bytes of the templateId at the given index.
     */
    public com.google.protobuf.ByteString
        getTemplateIdBytes(int index) {
      return templateId_.getByteString(index);
    }
    /**
     * <pre>
     * 被覆盖的音频模板Id, 支持ALL
     * </pre>
     *
     * <code>repeated string TemplateId = 1;</code>
     * @param index The index to set the value at.
     * @param value The templateId to set.
     * @return This builder for chaining.
     */
    public Builder setTemplateId(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureTemplateIdIsMutable();
      templateId_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 被覆盖的音频模板Id, 支持ALL
     * </pre>
     *
     * <code>repeated string TemplateId = 1;</code>
     * @param value The templateId to add.
     * @return This builder for chaining.
     */
    public Builder addTemplateId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureTemplateIdIsMutable();
      templateId_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 被覆盖的音频模板Id, 支持ALL
     * </pre>
     *
     * <code>repeated string TemplateId = 1;</code>
     * @param values The templateId to add.
     * @return This builder for chaining.
     */
    public Builder addAllTemplateId(
        java.lang.Iterable<java.lang.String> values) {
      ensureTemplateIdIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, templateId_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 被覆盖的音频模板Id, 支持ALL
     * </pre>
     *
     * <code>repeated string TemplateId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearTemplateId() {
      templateId_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 被覆盖的音频模板Id, 支持ALL
     * </pre>
     *
     * <code>repeated string TemplateId = 1;</code>
     * @param value The bytes of the templateId to add.
     * @return This builder for chaining.
     */
    public Builder addTemplateIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureTemplateIdIsMutable();
      templateId_.add(value);
      onChanged();
      return this;
    }

    private Clip clip_;
    private com.google.protobuf.SingleFieldBuilderV3<
        Clip, Clip.Builder, ClipOrBuilder> clipBuilder_;
    /**
     * <code>.Vcloud.Models.Vod.Clip Clip = 2;</code>
     * @return Whether the clip field is set.
     */
    public boolean hasClip() {
      return clipBuilder_ != null || clip_ != null;
    }
    /**
     * <code>.Vcloud.Models.Vod.Clip Clip = 2;</code>
     * @return The clip.
     */
    public Clip getClip() {
      if (clipBuilder_ == null) {
        return clip_ == null ? Clip.getDefaultInstance() : clip_;
      } else {
        return clipBuilder_.getMessage();
      }
    }
    /**
     * <code>.Vcloud.Models.Vod.Clip Clip = 2;</code>
     */
    public Builder setClip(Clip value) {
      if (clipBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        clip_ = value;
        onChanged();
      } else {
        clipBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Vcloud.Models.Vod.Clip Clip = 2;</code>
     */
    public Builder setClip(
        Clip.Builder builderForValue) {
      if (clipBuilder_ == null) {
        clip_ = builderForValue.build();
        onChanged();
      } else {
        clipBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Vcloud.Models.Vod.Clip Clip = 2;</code>
     */
    public Builder mergeClip(Clip value) {
      if (clipBuilder_ == null) {
        if (clip_ != null) {
          clip_ =
            Clip.newBuilder(clip_).mergeFrom(value).buildPartial();
        } else {
          clip_ = value;
        }
        onChanged();
      } else {
        clipBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Vcloud.Models.Vod.Clip Clip = 2;</code>
     */
    public Builder clearClip() {
      if (clipBuilder_ == null) {
        clip_ = null;
        onChanged();
      } else {
        clip_ = null;
        clipBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Vcloud.Models.Vod.Clip Clip = 2;</code>
     */
    public Clip.Builder getClipBuilder() {

      onChanged();
      return getClipFieldBuilder().getBuilder();
    }
    /**
     * <code>.Vcloud.Models.Vod.Clip Clip = 2;</code>
     */
    public ClipOrBuilder getClipOrBuilder() {
      if (clipBuilder_ != null) {
        return clipBuilder_.getMessageOrBuilder();
      } else {
        return clip_ == null ?
            Clip.getDefaultInstance() : clip_;
      }
    }
    /**
     * <code>.Vcloud.Models.Vod.Clip Clip = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        Clip, Clip.Builder, ClipOrBuilder>
        getClipFieldBuilder() {
      if (clipBuilder_ == null) {
        clipBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            Clip, Clip.Builder, ClipOrBuilder>(
                getClip(),
                getParentForChildren(),
                isClean());
        clip_ = null;
      }
      return clipBuilder_;
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


    // @@protoc_insertion_point(builder_scope:Vcloud.Models.Vod.TranscodeAudioOverride)
  }

  // @@protoc_insertion_point(class_scope:Vcloud.Models.Vod.TranscodeAudioOverride)
  private static final TranscodeAudioOverride DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new TranscodeAudioOverride();
  }

  public static TranscodeAudioOverride getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TranscodeAudioOverride>
      PARSER = new com.google.protobuf.AbstractParser<TranscodeAudioOverride>() {
    @java.lang.Override
    public TranscodeAudioOverride parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TranscodeAudioOverride(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TranscodeAudioOverride> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TranscodeAudioOverride> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public TranscodeAudioOverride getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

