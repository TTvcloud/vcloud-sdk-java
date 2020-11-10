// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod/business/vod_media.proto

package com.bytedanceapi.model.vod.business;

public final class VodMedia {
  private VodMedia() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodMediaBasicInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodMediaBasicInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodVideoInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodVideoInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodGetVideoInfosData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodGetVideoInfosData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodStoreUriGroup_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodStoreUriGroup_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodGetRecPosterData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodGetRecPosterData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034vod/business/vod_media.proto\022\021Vcloud.M" +
      "odels.Vod\032\035vod/business/vod_common.proto" +
      "\"\270\001\n\021VodMediaBasicInfo\022\021\n\tSpaceName\030\001 \001(" +
      "\t\022\013\n\003Vid\030\002 \001(\t\022\r\n\005Title\030\003 \001(\t\022\023\n\013Descrip" +
      "tion\030\004 \001(\t\022\021\n\tPosterUri\030\005 \001(\t\022\025\n\rPublish" +
      "Status\030\006 \001(\t\022\023\n\013AuditStatus\030\007 \001(\003\022\014\n\004Tag" +
      "s\030\010 \003(\t\022\022\n\nCreateTime\030\t \001(\t\"\272\001\n\014VodVideo" +
      "Info\0227\n\tBasicInfo\030\001 \001(\0132$.Vcloud.Models." +
      "Vod.VodMediaBasicInfo\0224\n\nSourceInfo\030\002 \001(" +
      "\0132 .Vcloud.Models.Vod.VodSourceInfo\022;\n\016T" +
      "ranscodeInfos\030\003 \003(\0132#.Vcloud.Models.Vod." +
      "VodTranscodeInfo\"d\n\024VodGetVideoInfosData" +
      "\0226\n\rVideoInfoList\030\001 \003(\0132\037.Vcloud.Models." +
      "Vod.VodVideoInfo\022\024\n\014NotExistVids\030\002 \003(\t\"2" +
      "\n\020VodStoreUriGroup\022\013\n\003Vid\030\001 \001(\t\022\021\n\tStore" +
      "Uris\030\002 \003(\t\"h\n\023VodGetRecPosterData\022;\n\016Sto" +
      "reUriGroups\030\001 \003(\0132#.Vcloud.Models.Vod.Vo" +
      "dStoreUriGroup\022\024\n\014NotExistVids\030\002 \003(\tB\256\001\n" +
      "#com.bytedanceapi.model.vod.businessB\010Vo" +
      "dMediaP\001Z9github.com/volcengine/volc-sdk" +
      "-golang/models/vod/business\240\001\001\330\001\001\302\002\000\312\002\032V" +
      "cloud\\Models\\Vod\\Business\342\002\031Vcloud\\Model" +
      "s\\GPBMetadatab\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.bytedanceapi.model.vod.business.VodCommon.getDescriptor(),
        });
    internal_static_Vcloud_Models_Vod_VodMediaBasicInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Vcloud_Models_Vod_VodMediaBasicInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodMediaBasicInfo_descriptor,
        new java.lang.String[] { "SpaceName", "Vid", "Title", "Description", "PosterUri", "PublishStatus", "AuditStatus", "Tags", "CreateTime", });
    internal_static_Vcloud_Models_Vod_VodVideoInfo_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Vcloud_Models_Vod_VodVideoInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodVideoInfo_descriptor,
        new java.lang.String[] { "BasicInfo", "SourceInfo", "TranscodeInfos", });
    internal_static_Vcloud_Models_Vod_VodGetVideoInfosData_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Vcloud_Models_Vod_VodGetVideoInfosData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodGetVideoInfosData_descriptor,
        new java.lang.String[] { "VideoInfoList", "NotExistVids", });
    internal_static_Vcloud_Models_Vod_VodStoreUriGroup_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Vcloud_Models_Vod_VodStoreUriGroup_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodStoreUriGroup_descriptor,
        new java.lang.String[] { "Vid", "StoreUris", });
    internal_static_Vcloud_Models_Vod_VodGetRecPosterData_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Vcloud_Models_Vod_VodGetRecPosterData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodGetRecPosterData_descriptor,
        new java.lang.String[] { "StoreUriGroups", "NotExistVids", });
    com.bytedanceapi.model.vod.business.VodCommon.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}