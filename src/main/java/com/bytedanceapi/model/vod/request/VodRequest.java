// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod/request/request_vod.proto

package com.bytedanceapi.model.vod.request;

public final class VodRequest {
  private VodRequest() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodGetPlayInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodGetPlayInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodUploadVideoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodUploadVideoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodGetRecommendedPosterRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodGetRecommendedPosterRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodUpdateVideoPublishStatusRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodUpdateVideoPublishStatusRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodUpdateVideoInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodUpdateVideoInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodGetVideoInfosRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodGetVideoInfosRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodStartWorkflowRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodStartWorkflowRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035vod/request/request_vod.proto\022\021Vcloud." +
      "Models.Vod\032\036google/protobuf/wrappers.pro" +
      "to\032\037vod/business/vod_workflow.proto\"\230\001\n\025" +
      "VodGetPlayInfoRequest\022\013\n\003Vid\030\001 \001(\t\022\016\n\006Fo" +
      "rmat\030\002 \001(\t\022\r\n\005Codec\030\003 \001(\t\022\022\n\nDefinition\030" +
      "\004 \001(\t\022\020\n\010FileType\030\005 \001(\t\022\020\n\010LogoType\030\006 \001(" +
      "\t\022\016\n\006Base64\030\007 \001(\t\022\013\n\003Ssl\030\010 \001(\t\"I\n\035VodGet" +
      "OriginalPlayInfoRequest\022\013\n\003Vid\030\001 \001(\t\022\016\n\006" +
      "Base64\030\002 \001(\t\022\013\n\003Ssl\030\003 \001(\t\"e\n\025VodUploadVi" +
      "deoRequest\022\021\n\tSpaceName\030\001 \001(\t\022\020\n\010FilePat" +
      "h\030\002 \001(\t\022\024\n\014CallbackArgs\030\003 \001(\t\022\021\n\tFunctio" +
      "ns\030\004 \001(\t\".\n\036VodGetRecommendedPosterReque" +
      "st\022\014\n\004Vids\030\001 \001(\t\"A\n\"VodUpdateVideoPublis" +
      "hStatusRequest\022\013\n\003Vid\030\001 \001(\t\022\016\n\006Status\030\002 " +
      "\001(\t\"\345\001\n\031VodUpdateVideoInfoRequest\022\013\n\003Vid" +
      "\030\001 \001(\t\022/\n\tPosterUri\030\002 \001(\0132\034.google.proto" +
      "buf.StringValue\022+\n\005Title\030\003 \001(\0132\034.google." +
      "protobuf.StringValue\0221\n\013Description\030\004 \001(" +
      "\0132\034.google.protobuf.StringValue\022*\n\004Tags\030" +
      "\005 \001(\0132\034.google.protobuf.StringValue\"\'\n\027V" +
      "odGetVideoInfosRequest\022\014\n\004Vids\030\001 \001(\t\"\224\001\n" +
      "\027VodStartWorkflowRequest\022\013\n\003Vid\030\001 \001(\t\022\022\n" +
      "\nTemplateId\030\002 \001(\t\0220\n\005Input\030\003 \001(\0132!.Vclou" +
      "d.Models.Vod.WorkflowParams\022\020\n\010Priority\030" +
      "\004 \001(\005\022\024\n\014CallbackArgs\030\005 \001(\tB\252\001\n\"com.byte" +
      "danceapi.model.vod.requestB\nVodRequestP\001" +
      "Z8github.com/volcengine/volc-sdk-golang/" +
      "models/vod/request\240\001\001\330\001\001\312\002\031Vcloud\\Models" +
      "\\Vod\\Request\342\002\031Vcloud\\Models\\GPBMetadata" +
      "b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
          com.bytedanceapi.model.vod.business.VodWorkflow.getDescriptor(),
        });
    internal_static_Vcloud_Models_Vod_VodGetPlayInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Vcloud_Models_Vod_VodGetPlayInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodGetPlayInfoRequest_descriptor,
        new java.lang.String[] { "Vid", "Format", "Codec", "Definition", "FileType", "LogoType", "Base64", "Ssl", });
    internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoRequest_descriptor,
        new java.lang.String[] { "Vid", "Base64", "Ssl", });
    internal_static_Vcloud_Models_Vod_VodUploadVideoRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Vcloud_Models_Vod_VodUploadVideoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodUploadVideoRequest_descriptor,
        new java.lang.String[] { "SpaceName", "FilePath", "CallbackArgs", "Functions", });
    internal_static_Vcloud_Models_Vod_VodGetRecommendedPosterRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Vcloud_Models_Vod_VodGetRecommendedPosterRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodGetRecommendedPosterRequest_descriptor,
        new java.lang.String[] { "Vids", });
    internal_static_Vcloud_Models_Vod_VodUpdateVideoPublishStatusRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Vcloud_Models_Vod_VodUpdateVideoPublishStatusRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodUpdateVideoPublishStatusRequest_descriptor,
        new java.lang.String[] { "Vid", "Status", });
    internal_static_Vcloud_Models_Vod_VodUpdateVideoInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Vcloud_Models_Vod_VodUpdateVideoInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodUpdateVideoInfoRequest_descriptor,
        new java.lang.String[] { "Vid", "PosterUri", "Title", "Description", "Tags", });
    internal_static_Vcloud_Models_Vod_VodGetVideoInfosRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Vcloud_Models_Vod_VodGetVideoInfosRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodGetVideoInfosRequest_descriptor,
        new java.lang.String[] { "Vids", });
    internal_static_Vcloud_Models_Vod_VodStartWorkflowRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Vcloud_Models_Vod_VodStartWorkflowRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodStartWorkflowRequest_descriptor,
        new java.lang.String[] { "Vid", "TemplateId", "Input", "Priority", "CallbackArgs", });
    com.google.protobuf.WrappersProto.getDescriptor();
    com.bytedanceapi.model.vod.business.VodWorkflow.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
