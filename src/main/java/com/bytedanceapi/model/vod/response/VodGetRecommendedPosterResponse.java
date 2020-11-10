// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod/response/response_vod.proto

package com.bytedanceapi.model.vod.response;

/**
 * Protobuf type {@code Vcloud.Models.Vod.VodGetRecommendedPosterResponse}
 */
public final class VodGetRecommendedPosterResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Vcloud.Models.Vod.VodGetRecommendedPosterResponse)
    VodGetRecommendedPosterResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VodGetRecommendedPosterResponse.newBuilder() to construct.
  private VodGetRecommendedPosterResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VodGetRecommendedPosterResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VodGetRecommendedPosterResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private VodGetRecommendedPosterResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
            com.bytedanceapi.model.common.ResponseMetadata.Builder subBuilder = null;
            if (responseMetadata_ != null) {
              subBuilder = responseMetadata_.toBuilder();
            }
            responseMetadata_ = input.readMessage(com.bytedanceapi.model.common.ResponseMetadata.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(responseMetadata_);
              responseMetadata_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            com.bytedanceapi.model.vod.business.VodGetRecPosterData.Builder subBuilder = null;
            if (result_ != null) {
              subBuilder = result_.toBuilder();
            }
            result_ = input.readMessage(com.bytedanceapi.model.vod.business.VodGetRecPosterData.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(result_);
              result_ = subBuilder.buildPartial();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return VodResponse.internal_static_Vcloud_Models_Vod_VodGetRecommendedPosterResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return VodResponse.internal_static_Vcloud_Models_Vod_VodGetRecommendedPosterResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            VodGetRecommendedPosterResponse.class, Builder.class);
  }

  public static final int RESPONSEMETADATA_FIELD_NUMBER = 1;
  private com.bytedanceapi.model.common.ResponseMetadata responseMetadata_;
  /**
   * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
   * @return Whether the responseMetadata field is set.
   */
  @java.lang.Override
  public boolean hasResponseMetadata() {
    return responseMetadata_ != null;
  }
  /**
   * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
   * @return The responseMetadata.
   */
  @java.lang.Override
  public com.bytedanceapi.model.common.ResponseMetadata getResponseMetadata() {
    return responseMetadata_ == null ? com.bytedanceapi.model.common.ResponseMetadata.getDefaultInstance() : responseMetadata_;
  }
  /**
   * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
   */
  @java.lang.Override
  public com.bytedanceapi.model.common.ResponseMetadataOrBuilder getResponseMetadataOrBuilder() {
    return getResponseMetadata();
  }

  public static final int RESULT_FIELD_NUMBER = 2;
  private com.bytedanceapi.model.vod.business.VodGetRecPosterData result_;
  /**
   * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
   * @return Whether the result field is set.
   */
  @java.lang.Override
  public boolean hasResult() {
    return result_ != null;
  }
  /**
   * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
   * @return The result.
   */
  @java.lang.Override
  public com.bytedanceapi.model.vod.business.VodGetRecPosterData getResult() {
    return result_ == null ? com.bytedanceapi.model.vod.business.VodGetRecPosterData.getDefaultInstance() : result_;
  }
  /**
   * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
   */
  @java.lang.Override
  public com.bytedanceapi.model.vod.business.VodGetRecPosterDataOrBuilder getResultOrBuilder() {
    return getResult();
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
    if (responseMetadata_ != null) {
      output.writeMessage(1, getResponseMetadata());
    }
    if (result_ != null) {
      output.writeMessage(2, getResult());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (responseMetadata_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getResponseMetadata());
    }
    if (result_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getResult());
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
    if (!(obj instanceof VodGetRecommendedPosterResponse)) {
      return super.equals(obj);
    }
    VodGetRecommendedPosterResponse other = (VodGetRecommendedPosterResponse) obj;

    if (hasResponseMetadata() != other.hasResponseMetadata()) return false;
    if (hasResponseMetadata()) {
      if (!getResponseMetadata()
          .equals(other.getResponseMetadata())) return false;
    }
    if (hasResult() != other.hasResult()) return false;
    if (hasResult()) {
      if (!getResult()
          .equals(other.getResult())) return false;
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
    if (hasResponseMetadata()) {
      hash = (37 * hash) + RESPONSEMETADATA_FIELD_NUMBER;
      hash = (53 * hash) + getResponseMetadata().hashCode();
    }
    if (hasResult()) {
      hash = (37 * hash) + RESULT_FIELD_NUMBER;
      hash = (53 * hash) + getResult().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static VodGetRecommendedPosterResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static VodGetRecommendedPosterResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static VodGetRecommendedPosterResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static VodGetRecommendedPosterResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static VodGetRecommendedPosterResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static VodGetRecommendedPosterResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static VodGetRecommendedPosterResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static VodGetRecommendedPosterResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static VodGetRecommendedPosterResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static VodGetRecommendedPosterResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static VodGetRecommendedPosterResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static VodGetRecommendedPosterResponse parseFrom(
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
  public static Builder newBuilder(VodGetRecommendedPosterResponse prototype) {
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
   * Protobuf type {@code Vcloud.Models.Vod.VodGetRecommendedPosterResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Vcloud.Models.Vod.VodGetRecommendedPosterResponse)
      VodGetRecommendedPosterResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return VodResponse.internal_static_Vcloud_Models_Vod_VodGetRecommendedPosterResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return VodResponse.internal_static_Vcloud_Models_Vod_VodGetRecommendedPosterResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              VodGetRecommendedPosterResponse.class, Builder.class);
    }

    // Construct using com.bytedanceapi.model.vod.response.VodGetRecommendedPosterResponse.newBuilder()
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
      if (responseMetadataBuilder_ == null) {
        responseMetadata_ = null;
      } else {
        responseMetadata_ = null;
        responseMetadataBuilder_ = null;
      }
      if (resultBuilder_ == null) {
        result_ = null;
      } else {
        result_ = null;
        resultBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return VodResponse.internal_static_Vcloud_Models_Vod_VodGetRecommendedPosterResponse_descriptor;
    }

    @java.lang.Override
    public VodGetRecommendedPosterResponse getDefaultInstanceForType() {
      return VodGetRecommendedPosterResponse.getDefaultInstance();
    }

    @java.lang.Override
    public VodGetRecommendedPosterResponse build() {
      VodGetRecommendedPosterResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public VodGetRecommendedPosterResponse buildPartial() {
      VodGetRecommendedPosterResponse result = new VodGetRecommendedPosterResponse(this);
      if (responseMetadataBuilder_ == null) {
        result.responseMetadata_ = responseMetadata_;
      } else {
        result.responseMetadata_ = responseMetadataBuilder_.build();
      }
      if (resultBuilder_ == null) {
        result.result_ = result_;
      } else {
        result.result_ = resultBuilder_.build();
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
      if (other instanceof VodGetRecommendedPosterResponse) {
        return mergeFrom((VodGetRecommendedPosterResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(VodGetRecommendedPosterResponse other) {
      if (other == VodGetRecommendedPosterResponse.getDefaultInstance()) return this;
      if (other.hasResponseMetadata()) {
        mergeResponseMetadata(other.getResponseMetadata());
      }
      if (other.hasResult()) {
        mergeResult(other.getResult());
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
      VodGetRecommendedPosterResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (VodGetRecommendedPosterResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.bytedanceapi.model.common.ResponseMetadata responseMetadata_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.bytedanceapi.model.common.ResponseMetadata, com.bytedanceapi.model.common.ResponseMetadata.Builder, com.bytedanceapi.model.common.ResponseMetadataOrBuilder> responseMetadataBuilder_;
    /**
     * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
     * @return Whether the responseMetadata field is set.
     */
    public boolean hasResponseMetadata() {
      return responseMetadataBuilder_ != null || responseMetadata_ != null;
    }
    /**
     * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
     * @return The responseMetadata.
     */
    public com.bytedanceapi.model.common.ResponseMetadata getResponseMetadata() {
      if (responseMetadataBuilder_ == null) {
        return responseMetadata_ == null ? com.bytedanceapi.model.common.ResponseMetadata.getDefaultInstance() : responseMetadata_;
      } else {
        return responseMetadataBuilder_.getMessage();
      }
    }
    /**
     * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
     */
    public Builder setResponseMetadata(com.bytedanceapi.model.common.ResponseMetadata value) {
      if (responseMetadataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        responseMetadata_ = value;
        onChanged();
      } else {
        responseMetadataBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
     */
    public Builder setResponseMetadata(
        com.bytedanceapi.model.common.ResponseMetadata.Builder builderForValue) {
      if (responseMetadataBuilder_ == null) {
        responseMetadata_ = builderForValue.build();
        onChanged();
      } else {
        responseMetadataBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
     */
    public Builder mergeResponseMetadata(com.bytedanceapi.model.common.ResponseMetadata value) {
      if (responseMetadataBuilder_ == null) {
        if (responseMetadata_ != null) {
          responseMetadata_ =
            com.bytedanceapi.model.common.ResponseMetadata.newBuilder(responseMetadata_).mergeFrom(value).buildPartial();
        } else {
          responseMetadata_ = value;
        }
        onChanged();
      } else {
        responseMetadataBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
     */
    public Builder clearResponseMetadata() {
      if (responseMetadataBuilder_ == null) {
        responseMetadata_ = null;
        onChanged();
      } else {
        responseMetadata_ = null;
        responseMetadataBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
     */
    public com.bytedanceapi.model.common.ResponseMetadata.Builder getResponseMetadataBuilder() {

      onChanged();
      return getResponseMetadataFieldBuilder().getBuilder();
    }
    /**
     * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
     */
    public com.bytedanceapi.model.common.ResponseMetadataOrBuilder getResponseMetadataOrBuilder() {
      if (responseMetadataBuilder_ != null) {
        return responseMetadataBuilder_.getMessageOrBuilder();
      } else {
        return responseMetadata_ == null ?
            com.bytedanceapi.model.common.ResponseMetadata.getDefaultInstance() : responseMetadata_;
      }
    }
    /**
     * <code>.Vcloud.Models.Base.ResponseMetadata ResponseMetadata = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.bytedanceapi.model.common.ResponseMetadata, com.bytedanceapi.model.common.ResponseMetadata.Builder, com.bytedanceapi.model.common.ResponseMetadataOrBuilder>
        getResponseMetadataFieldBuilder() {
      if (responseMetadataBuilder_ == null) {
        responseMetadataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.bytedanceapi.model.common.ResponseMetadata, com.bytedanceapi.model.common.ResponseMetadata.Builder, com.bytedanceapi.model.common.ResponseMetadataOrBuilder>(
                getResponseMetadata(),
                getParentForChildren(),
                isClean());
        responseMetadata_ = null;
      }
      return responseMetadataBuilder_;
    }

    private com.bytedanceapi.model.vod.business.VodGetRecPosterData result_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.bytedanceapi.model.vod.business.VodGetRecPosterData, com.bytedanceapi.model.vod.business.VodGetRecPosterData.Builder, com.bytedanceapi.model.vod.business.VodGetRecPosterDataOrBuilder> resultBuilder_;
    /**
     * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
     * @return Whether the result field is set.
     */
    public boolean hasResult() {
      return resultBuilder_ != null || result_ != null;
    }
    /**
     * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
     * @return The result.
     */
    public com.bytedanceapi.model.vod.business.VodGetRecPosterData getResult() {
      if (resultBuilder_ == null) {
        return result_ == null ? com.bytedanceapi.model.vod.business.VodGetRecPosterData.getDefaultInstance() : result_;
      } else {
        return resultBuilder_.getMessage();
      }
    }
    /**
     * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
     */
    public Builder setResult(com.bytedanceapi.model.vod.business.VodGetRecPosterData value) {
      if (resultBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        result_ = value;
        onChanged();
      } else {
        resultBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
     */
    public Builder setResult(
        com.bytedanceapi.model.vod.business.VodGetRecPosterData.Builder builderForValue) {
      if (resultBuilder_ == null) {
        result_ = builderForValue.build();
        onChanged();
      } else {
        resultBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
     */
    public Builder mergeResult(com.bytedanceapi.model.vod.business.VodGetRecPosterData value) {
      if (resultBuilder_ == null) {
        if (result_ != null) {
          result_ =
            com.bytedanceapi.model.vod.business.VodGetRecPosterData.newBuilder(result_).mergeFrom(value).buildPartial();
        } else {
          result_ = value;
        }
        onChanged();
      } else {
        resultBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
     */
    public Builder clearResult() {
      if (resultBuilder_ == null) {
        result_ = null;
        onChanged();
      } else {
        result_ = null;
        resultBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
     */
    public com.bytedanceapi.model.vod.business.VodGetRecPosterData.Builder getResultBuilder() {

      onChanged();
      return getResultFieldBuilder().getBuilder();
    }
    /**
     * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
     */
    public com.bytedanceapi.model.vod.business.VodGetRecPosterDataOrBuilder getResultOrBuilder() {
      if (resultBuilder_ != null) {
        return resultBuilder_.getMessageOrBuilder();
      } else {
        return result_ == null ?
            com.bytedanceapi.model.vod.business.VodGetRecPosterData.getDefaultInstance() : result_;
      }
    }
    /**
     * <code>.Vcloud.Models.Vod.VodGetRecPosterData Result = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.bytedanceapi.model.vod.business.VodGetRecPosterData, com.bytedanceapi.model.vod.business.VodGetRecPosterData.Builder, com.bytedanceapi.model.vod.business.VodGetRecPosterDataOrBuilder>
        getResultFieldBuilder() {
      if (resultBuilder_ == null) {
        resultBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.bytedanceapi.model.vod.business.VodGetRecPosterData, com.bytedanceapi.model.vod.business.VodGetRecPosterData.Builder, com.bytedanceapi.model.vod.business.VodGetRecPosterDataOrBuilder>(
                getResult(),
                getParentForChildren(),
                isClean());
        result_ = null;
      }
      return resultBuilder_;
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


    // @@protoc_insertion_point(builder_scope:Vcloud.Models.Vod.VodGetRecommendedPosterResponse)
  }

  // @@protoc_insertion_point(class_scope:Vcloud.Models.Vod.VodGetRecommendedPosterResponse)
  private static final VodGetRecommendedPosterResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new VodGetRecommendedPosterResponse();
  }

  public static VodGetRecommendedPosterResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VodGetRecommendedPosterResponse>
      PARSER = new com.google.protobuf.AbstractParser<VodGetRecommendedPosterResponse>() {
    @java.lang.Override
    public VodGetRecommendedPosterResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new VodGetRecommendedPosterResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<VodGetRecommendedPosterResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VodGetRecommendedPosterResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public VodGetRecommendedPosterResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

