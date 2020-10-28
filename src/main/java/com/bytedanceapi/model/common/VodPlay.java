// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod_play.proto

package com.bytedanceapi.model.common;

public final class VodPlay {
  private VodPlay() {}
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
    internal_static_Vcloud_Models_Vod_VodGetPlayInfoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodGetPlayInfoResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodGetPlayInfoResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodGetPlayInfoResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodAdaptiveInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodAdaptiveInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodPlayInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodPlayInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoResult_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016vod_play.proto\022\021Vcloud.Models.Vod\032\nbas" +
      "e.proto\032\034google/api/annotations.proto\"\230\001" +
      "\n\025VodGetPlayInfoRequest\022\013\n\003Vid\030\001 \001(\t\022\016\n\006" +
      "Format\030\002 \001(\t\022\r\n\005Codec\030\003 \001(\t\022\022\n\nDefinitio" +
      "n\030\004 \001(\t\022\020\n\010FileType\030\005 \001(\t\022\020\n\010LogoType\030\006 " +
      "\001(\t\022\016\n\006Base64\030\007 \001(\003\022\013\n\003Ssl\030\010 \001(\003\"\221\001\n\026Vod" +
      "GetPlayInfoResponse\022>\n\020ResponseMetadata\030" +
      "\001 \001(\0132$.Vcloud.Models.Base.ResponseMetad" +
      "ata\0227\n\006Result\030\002 \001(\0132\'.Vcloud.Models.Vod." +
      "VodGetPlayInfoResult\"\206\002\n\024VodGetPlayInfoR" +
      "esult\022\013\n\003Vid\030\001 \001(\t\022\016\n\006Status\030\002 \001(\003\022\021\n\tPo" +
      "sterUrl\030\003 \001(\t\022\020\n\010Duration\030\004 \001(\002\022\020\n\010FileT" +
      "ype\030\005 \001(\t\022\026\n\016EnableAdaptive\030\006 \001(\010\022\022\n\nTot" +
      "alCount\030\007 \001(\003\0228\n\014AdaptiveInfo\030\010 \001(\0132\".Vc" +
      "loud.Models.Vod.VodAdaptiveInfo\0224\n\014PlayI" +
      "nfoList\030\t \003(\0132\036.Vcloud.Models.Vod.VodPla" +
      "yInfo\"S\n\017VodAdaptiveInfo\022\023\n\013MainPlayUrl\030" +
      "\001 \001(\t\022\025\n\rBackupPlayUrl\030\002 \001(\t\022\024\n\014Adaptive" +
      "Type\030\003 \001(\t\"\320\003\n\013VodPlayInfo\022\016\n\006FileId\030\001 \001" +
      "(\t\022\013\n\003Md5\030\002 \001(\t\022\020\n\010FileType\030\003 \001(\t\022\016\n\006For" +
      "mat\030\004 \001(\t\022\r\n\005Codec\030\005 \001(\t\022\022\n\nDefinition\030\006" +
      " \001(\t\022\023\n\013MainPlayUrl\030\007 \001(\t\022\025\n\rBackupPlayU" +
      "rl\030\010 \001(\t\022\017\n\007Bitrate\030\t \001(\002\022\r\n\005Width\030\n \001(\003" +
      "\022\016\n\006Height\030\013 \001(\003\022\014\n\004Size\030\014 \001(\003\022\021\n\tCheckI" +
      "nfo\030\r \001(\t\022\022\n\nIndexRange\030\016 \001(\t\022\021\n\tInitRan" +
      "ge\030\017 \001(\t\022\023\n\013PreloadSize\030\020 \001(\003\022\026\n\016Preload" +
      "MinStep\030\021 \001(\003\022\026\n\016PreloadMaxStep\030\022 \001(\003\022\027\n" +
      "\017PreloadInterval\030\023 \001(\003\022\024\n\014P2pVerifyUrl\030\024" +
      " \001(\t\022\020\n\010PlayAuth\030\025 \001(\t\022\022\n\nPlayAuthId\030\026 \001" +
      "(\t\022\020\n\010LogoType\030\027 \001(\t\022\017\n\007Quality\030\030 \001(\t\"I\n" +
      "\035VodGetOriginalPlayInfoRequest\022\013\n\003Vid\030\001 " +
      "\001(\t\022\016\n\006Base64\030\002 \001(\003\022\013\n\003Ssl\030\003 \001(\003\"\241\001\n\036Vod" +
      "GetOriginalPlayInfoResponse\022>\n\020ResponseM" +
      "etadata\030\001 \001(\0132$.Vcloud.Models.Base.Respo" +
      "nseMetadata\022?\n\006Result\030\002 \001(\0132/.Vcloud.Mod" +
      "els.Vod.VodGetOriginalPlayInfoResult\"\330\001\n" +
      "\034VodGetOriginalPlayInfoResult\022\020\n\010FileTyp" +
      "e\030\001 \001(\t\022\020\n\010Duration\030\002 \001(\002\022\014\n\004Size\030\003 \001(\003\022" +
      "\016\n\006Height\030\004 \001(\003\022\r\n\005Width\030\005 \001(\003\022\016\n\006Format" +
      "\030\006 \001(\t\022\r\n\005Codec\030\007 \001(\t\022\017\n\007Bitrate\030\010 \001(\002\022\013" +
      "\n\003Md5\030\t \001(\t\022\023\n\013MainPlayUrl\030\n \001(\t\022\025\n\rBack" +
      "upPlayUrl\030\013 \001(\t2\236\004\n\016VodPlayService\022\356\001\n\013G" +
      "etPlayInfo\022(.Vcloud.Models.Vod.VodGetPla" +
      "yInfoRequest\032).Vcloud.Models.Vod.VodGetP" +
      "layInfoResponse\"\211\001\202\323\344\223\002\202\001\022\'/?Action=GetP" +
      "layInfo&Version=2020-08-01:\025VodGetPlayIn" +
      "foRequestZ@\"\'/?Action=GetPlayInfo&Versio" +
      "n=2020-08-01:\025VodGetPlayInfoRequest\022\232\002\n\023" +
      "GetOriginalPlayInfo\0220.Vcloud.Models.Vod." +
      "VodGetOriginalPlayInfoRequest\0321.Vcloud.M" +
      "odels.Vod.VodGetOriginalPlayInfoResponse" +
      "\"\235\001\202\323\344\223\002\226\001\022)/video/atlas/top/vod/v2/GetO" +
      "riginPlayInfo:\035VodGetOriginalPlayInfoReq" +
      "uestZJ\")/video/atlas/top/vod/v2/GetOrigi" +
      "nPlayInfo:\035VodGetOriginalPlayInfoRequest" +
      "Bm\n\035com.bytedanceapi.model.commonB\007VodPl" +
      "ayP\001Z\010.;models\240\001\001\330\001\001\302\002\000\312\002\021Vcloud\\Models\\" +
      "Vod\342\002\031Vcloud\\Models\\GPBMetadatab\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.bytedanceapi.model.common.Base.getDescriptor(),
          com.google.api.AnnotationsProto.getDescriptor(),
        });
    internal_static_Vcloud_Models_Vod_VodGetPlayInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Vcloud_Models_Vod_VodGetPlayInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodGetPlayInfoRequest_descriptor,
        new java.lang.String[] { "Vid", "Format", "Codec", "Definition", "FileType", "LogoType", "Base64", "Ssl", });
    internal_static_Vcloud_Models_Vod_VodGetPlayInfoResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Vcloud_Models_Vod_VodGetPlayInfoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodGetPlayInfoResponse_descriptor,
        new java.lang.String[] { "ResponseMetadata", "Result", });
    internal_static_Vcloud_Models_Vod_VodGetPlayInfoResult_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Vcloud_Models_Vod_VodGetPlayInfoResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodGetPlayInfoResult_descriptor,
        new java.lang.String[] { "Vid", "Status", "PosterUrl", "Duration", "FileType", "EnableAdaptive", "TotalCount", "AdaptiveInfo", "PlayInfoList", });
    internal_static_Vcloud_Models_Vod_VodAdaptiveInfo_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Vcloud_Models_Vod_VodAdaptiveInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodAdaptiveInfo_descriptor,
        new java.lang.String[] { "MainPlayUrl", "BackupPlayUrl", "AdaptiveType", });
    internal_static_Vcloud_Models_Vod_VodPlayInfo_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Vcloud_Models_Vod_VodPlayInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodPlayInfo_descriptor,
        new java.lang.String[] { "FileId", "Md5", "FileType", "Format", "Codec", "Definition", "MainPlayUrl", "BackupPlayUrl", "Bitrate", "Width", "Height", "Size", "CheckInfo", "IndexRange", "InitRange", "PreloadSize", "PreloadMinStep", "PreloadMaxStep", "PreloadInterval", "P2PVerifyUrl", "PlayAuth", "PlayAuthId", "LogoType", "Quality", });
    internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoRequest_descriptor,
        new java.lang.String[] { "Vid", "Base64", "Ssl", });
    internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoResponse_descriptor,
        new java.lang.String[] { "ResponseMetadata", "Result", });
    internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoResult_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Vcloud_Models_Vod_VodGetOriginalPlayInfoResult_descriptor,
        new java.lang.String[] { "FileType", "Duration", "Size", "Height", "Width", "Format", "Codec", "Bitrate", "Md5", "MainPlayUrl", "BackupPlayUrl", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.AnnotationsProto.http);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.bytedanceapi.model.common.Base.getDescriptor();
    com.google.api.AnnotationsProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
