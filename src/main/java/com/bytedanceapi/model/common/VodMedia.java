// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod_media.proto

package com.bytedanceapi.model.common;

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
    internal_static_Vcloud_Models_Vod_UpdateVideoPublishStatusRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_UpdateVideoPublishStatusRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_UpdateVideoPublishStatusResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_UpdateVideoPublishStatusResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_UpdateVideoInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_UpdateVideoInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_UpdateVideoInfoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_UpdateVideoInfoResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_GetVideoInfosRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_GetVideoInfosRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_AudioStreamMeta_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_AudioStreamMeta_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VideoStreamMeta_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VideoStreamMeta_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_TranscodeInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_TranscodeInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_SourceInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_SourceInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_BasicInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_BasicInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VideoInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VideoInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_GetVideoInfosData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_GetVideoInfosData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_GetVideoInfosResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_GetVideoInfosResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_GetRecommendedPostersRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_GetRecommendedPostersRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_StoreUriGroup_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_StoreUriGroup_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_GetRecPostersData_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_GetRecPostersData_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_GetRecPostersResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_GetRecPostersResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\017vod_media.proto\022\021Vcloud.Models.Vod\032\nba" +
      "se.proto\032\036google/protobuf/wrappers.proto" +
      "\032\034google/api/annotations.proto\">\n\037Update" +
      "VideoPublishStatusRequest\022\013\n\003Vid\030\001 \001(\t\022\016" +
      "\n\006Status\030\002 \001(\t\"b\n UpdateVideoPublishStat" +
      "usResponse\022>\n\020ResponseMetadata\030\001 \001(\0132$.V" +
      "cloud.Models.Base.ResponseMetadata\"\342\001\n\026U" +
      "pdateVideoInfoRequest\022\013\n\003Vid\030\001 \001(\t\022/\n\tPo" +
      "sterUri\030\002 \001(\0132\034.google.protobuf.StringVa" +
      "lue\022+\n\005Title\030\003 \001(\0132\034.google.protobuf.Str" +
      "ingValue\0221\n\013Description\030\004 \001(\0132\034.google.p" +
      "rotobuf.StringValue\022*\n\004Tags\030\005 \001(\0132\034.goog" +
      "le.protobuf.StringValue\"Y\n\027UpdateVideoIn" +
      "foResponse\022>\n\020ResponseMetadata\030\001 \001(\0132$.V" +
      "cloud.Models.Base.ResponseMetadata\"$\n\024Ge" +
      "tVideoInfosRequest\022\014\n\004Vids\030\001 \001(\t\"W\n\017Audi" +
      "oStreamMeta\022\r\n\005Codec\030\001 \001(\t\022\020\n\010Duration\030\002" +
      " \001(\002\022\022\n\nSampleRate\030\003 \001(\003\022\017\n\007Bitrate\030\004 \001(" +
      "\003\"\203\001\n\017VideoStreamMeta\022\r\n\005Codec\030\001 \001(\t\022\016\n\006" +
      "Height\030\002 \001(\003\022\r\n\005Width\030\003 \001(\003\022\020\n\010Duration\030" +
      "\004 \001(\002\022\022\n\nDefinition\030\005 \001(\t\022\017\n\007Bitrate\030\006 \001" +
      "(\003\022\013\n\003Fps\030\007 \001(\002\"\261\002\n\rTranscodeInfo\022\016\n\006Fil" +
      "eId\030\001 \001(\t\022\013\n\003Md5\030\002 \001(\t\022\020\n\010FileType\030\003 \001(\t" +
      "\022\020\n\010LogoType\030\004 \001(\t\022\017\n\007Encrypt\030\005 \001(\010\022\016\n\006F" +
      "ormat\030\006 \001(\t\022\020\n\010Duration\030\007 \001(\002\022\014\n\004Size\030\010 " +
      "\001(\003\022\020\n\010StoreUri\030\t \001(\t\022;\n\017VideoStreamMeta" +
      "\030\n \001(\0132\".Vcloud.Models.Vod.VideoStreamMe" +
      "ta\022;\n\017AudioStreamMeta\030\013 \001(\0132\".Vcloud.Mod" +
      "els.Vod.AudioStreamMeta\022\022\n\nCreateTime\030\014 " +
      "\001(\t\"\361\001\n\nSourceInfo\022\016\n\006FileId\030\001 \001(\t\022\013\n\003Md" +
      "5\030\002 \001(\t\022\020\n\010FileType\030\003 \001(\t\022\r\n\005Codec\030\004 \001(\t" +
      "\022\016\n\006Height\030\005 \001(\003\022\r\n\005Width\030\006 \001(\003\022\016\n\006Forma" +
      "t\030\007 \001(\t\022\020\n\010Duration\030\010 \001(\002\022\014\n\004Size\030\t \001(\003\022" +
      "\020\n\010StoreUri\030\n \001(\t\022\022\n\nDefinition\030\013 \001(\t\022\017\n" +
      "\007Bitrate\030\014 \001(\003\022\013\n\003Fps\030\r \001(\002\022\022\n\nCreateTim" +
      "e\030\016 \001(\t\"\260\001\n\tBasicInfo\022\021\n\tSpaceName\030\001 \001(\t" +
      "\022\013\n\003Vid\030\002 \001(\t\022\r\n\005Title\030\003 \001(\t\022\023\n\013Descript" +
      "ion\030\004 \001(\t\022\021\n\tPosterUri\030\005 \001(\t\022\025\n\rPublishS" +
      "tatus\030\006 \001(\t\022\023\n\013AuditStatus\030\007 \001(\003\022\014\n\004Tags" +
      "\030\010 \003(\t\022\022\n\nCreateTime\030\t \001(\t\"\251\001\n\tVideoInfo" +
      "\022/\n\tBasicInfo\030\001 \001(\0132\034.Vcloud.Models.Vod." +
      "BasicInfo\0221\n\nSourceInfo\030\002 \001(\0132\035.Vcloud.M" +
      "odels.Vod.SourceInfo\0228\n\016TranscodeInfos\030\003" +
      " \003(\0132 .Vcloud.Models.Vod.TranscodeInfo\"^" +
      "\n\021GetVideoInfosData\0223\n\rVideoInfoList\030\001 \003" +
      "(\0132\034.Vcloud.Models.Vod.VideoInfo\022\024\n\014NotE" +
      "xistVids\030\002 \003(\t\"\215\001\n\025GetVideoInfosResponse" +
      "\022>\n\020ResponseMetadata\030\001 \001(\0132$.Vcloud.Mode" +
      "ls.Base.ResponseMetadata\0224\n\006Result\030\002 \001(\013" +
      "2$.Vcloud.Models.Vod.GetVideoInfosData\"," +
      "\n\034GetRecommendedPostersRequest\022\014\n\004Vids\030\001" +
      " \001(\t\"/\n\rStoreUriGroup\022\013\n\003Vid\030\001 \001(\t\022\021\n\tSt" +
      "oreUris\030\002 \003(\t\"c\n\021GetRecPostersData\0228\n\016St" +
      "oreUriGroups\030\001 \003(\0132 .Vcloud.Models.Vod.S" +
      "toreUriGroup\022\024\n\014NotExistVids\030\002 \003(\t\"\215\001\n\025G" +
      "etRecPostersResponse\022>\n\020ResponseMetadata" +
      "\030\001 \001(\0132$.Vcloud.Models.Base.ResponseMeta" +
      "data\0224\n\006Result\030\002 \001(\0132$.Vcloud.Models.Vod" +
      ".GetRecPostersData2\255\001\n\017VodMediaService\022\231" +
      "\001\n\017updateVideoInfo\022).Vcloud.Models.Vod.U" +
      "pdateVideoInfoRequest\032*.Vcloud.Models.Vo" +
      "d.UpdateVideoInfoResponse\"/\202\323\344\223\002)\022\020/Upda" +
      "teVideoInfoZ\025\"\020/UpdateVideoInfo:\001*Bn\n\035co" +
      "m.bytedanceapi.model.commonB\010VodMediaP\001Z" +
      "\010.;models\240\001\001\330\001\001\302\002\000\312\002\021Vcloud\\Models\\Vod\342\002" +
      "\031Vcloud\\Models\\GPBMetadatab\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          Base.getDescriptor(),
          com.google.protobuf.WrappersProto.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
        });
    internal_static_Vcloud_Models_Vod_UpdateVideoPublishStatusRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Vcloud_Models_Vod_UpdateVideoPublishStatusRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_UpdateVideoPublishStatusRequest_descriptor,
        new String[] { "Vid", "Status", });
    internal_static_Vcloud_Models_Vod_UpdateVideoPublishStatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Vcloud_Models_Vod_UpdateVideoPublishStatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_UpdateVideoPublishStatusResponse_descriptor,
        new String[] { "ResponseMetadata", });
    internal_static_Vcloud_Models_Vod_UpdateVideoInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Vcloud_Models_Vod_UpdateVideoInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_UpdateVideoInfoRequest_descriptor,
        new String[] { "Vid", "PosterUri", "Title", "Description", "Tags", });
    internal_static_Vcloud_Models_Vod_UpdateVideoInfoResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Vcloud_Models_Vod_UpdateVideoInfoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_UpdateVideoInfoResponse_descriptor,
        new String[] { "ResponseMetadata", });
    internal_static_Vcloud_Models_Vod_GetVideoInfosRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Vcloud_Models_Vod_GetVideoInfosRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_GetVideoInfosRequest_descriptor,
        new String[] { "Vids", });
    internal_static_Vcloud_Models_Vod_AudioStreamMeta_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Vcloud_Models_Vod_AudioStreamMeta_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_AudioStreamMeta_descriptor,
        new String[] { "Codec", "Duration", "SampleRate", "Bitrate", });
    internal_static_Vcloud_Models_Vod_VideoStreamMeta_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Vcloud_Models_Vod_VideoStreamMeta_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VideoStreamMeta_descriptor,
        new String[] { "Codec", "Height", "Width", "Duration", "Definition", "Bitrate", "Fps", });
    internal_static_Vcloud_Models_Vod_TranscodeInfo_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Vcloud_Models_Vod_TranscodeInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_TranscodeInfo_descriptor,
        new String[] { "FileId", "Md5", "FileType", "LogoType", "Encrypt", "Format", "Duration", "Size", "StoreUri", "VideoStreamMeta", "AudioStreamMeta", "CreateTime", });
    internal_static_Vcloud_Models_Vod_SourceInfo_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_Vcloud_Models_Vod_SourceInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_SourceInfo_descriptor,
        new String[] { "FileId", "Md5", "FileType", "Codec", "Height", "Width", "Format", "Duration", "Size", "StoreUri", "Definition", "Bitrate", "Fps", "CreateTime", });
    internal_static_Vcloud_Models_Vod_BasicInfo_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_Vcloud_Models_Vod_BasicInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_BasicInfo_descriptor,
        new String[] { "SpaceName", "Vid", "Title", "Description", "PosterUri", "PublishStatus", "AuditStatus", "Tags", "CreateTime", });
    internal_static_Vcloud_Models_Vod_VideoInfo_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_Vcloud_Models_Vod_VideoInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VideoInfo_descriptor,
        new String[] { "BasicInfo", "SourceInfo", "TranscodeInfos", });
    internal_static_Vcloud_Models_Vod_GetVideoInfosData_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_Vcloud_Models_Vod_GetVideoInfosData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_GetVideoInfosData_descriptor,
        new String[] { "VideoInfoList", "NotExistVids", });
    internal_static_Vcloud_Models_Vod_GetVideoInfosResponse_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_Vcloud_Models_Vod_GetVideoInfosResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_GetVideoInfosResponse_descriptor,
        new String[] { "ResponseMetadata", "Result", });
    internal_static_Vcloud_Models_Vod_GetRecommendedPostersRequest_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_Vcloud_Models_Vod_GetRecommendedPostersRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_GetRecommendedPostersRequest_descriptor,
        new String[] { "Vids", });
    internal_static_Vcloud_Models_Vod_StoreUriGroup_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_Vcloud_Models_Vod_StoreUriGroup_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_StoreUriGroup_descriptor,
        new String[] { "Vid", "StoreUris", });
    internal_static_Vcloud_Models_Vod_GetRecPostersData_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_Vcloud_Models_Vod_GetRecPostersData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_GetRecPostersData_descriptor,
        new String[] { "StoreUriGroups", "NotExistVids", });
    internal_static_Vcloud_Models_Vod_GetRecPostersResponse_descriptor =
      getDescriptor().getMessageTypes().get(16);
    internal_static_Vcloud_Models_Vod_GetRecPostersResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_GetRecPostersResponse_descriptor,
        new String[] { "ResponseMetadata", "Result", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.AnnotationsProto.http);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    Base.getDescriptor();
    com.google.protobuf.WrappersProto.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
