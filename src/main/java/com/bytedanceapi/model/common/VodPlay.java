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
      "e.proto\"\230\001\n\025VodGetPlayInfoRequest\022\013\n\003Vid" +
      "\030\001 \001(\t\022\016\n\006Format\030\002 \001(\t\022\r\n\005Codec\030\003 \001(\t\022\022\n" +
      "\nDefinition\030\004 \001(\t\022\020\n\010FileType\030\005 \001(\t\022\020\n\010L" +
      "ogoType\030\006 \001(\t\022\016\n\006Base64\030\007 \001(\t\022\013\n\003Ssl\030\010 \001" +
      "(\t\"\221\001\n\026VodGetPlayInfoResponse\022>\n\020Respons" +
      "eMetadata\030\001 \001(\0132$.Vcloud.Models.Base.Res" +
      "ponseMetadata\0227\n\006Result\030\002 \001(\0132\'.Vcloud.M" +
      "odels.Vod.VodGetPlayInfoResult\"\206\002\n\024VodGe" +
      "tPlayInfoResult\022\013\n\003Vid\030\001 \001(\t\022\016\n\006Status\030\002" +
      " \001(\003\022\021\n\tPosterUrl\030\003 \001(\t\022\020\n\010Duration\030\004 \001(" +
      "\002\022\020\n\010FileType\030\005 \001(\t\022\026\n\016EnableAdaptive\030\006 " +
      "\001(\010\022\022\n\nTotalCount\030\007 \001(\003\0228\n\014AdaptiveInfo\030" +
      "\010 \001(\0132\".Vcloud.Models.Vod.VodAdaptiveInf" +
      "o\0224\n\014PlayInfoList\030\t \003(\0132\036.Vcloud.Models." +
      "Vod.VodPlayInfo\"S\n\017VodAdaptiveInfo\022\023\n\013Ma" +
      "inPlayUrl\030\001 \001(\t\022\025\n\rBackupPlayUrl\030\002 \001(\t\022\024" +
      "\n\014AdaptiveType\030\003 \001(\t\"\320\003\n\013VodPlayInfo\022\016\n\006" +
      "FileID\030\001 \001(\t\022\013\n\003Md5\030\002 \001(\t\022\020\n\010FileType\030\003 " +
      "\001(\t\022\016\n\006Format\030\004 \001(\t\022\r\n\005Codec\030\005 \001(\t\022\022\n\nDe" +
      "finition\030\006 \001(\t\022\023\n\013MainPlayUrl\030\007 \001(\t\022\025\n\rB" +
      "ackupPlayUrl\030\010 \001(\t\022\017\n\007Bitrate\030\t \001(\002\022\r\n\005W" +
      "idth\030\n \001(\003\022\016\n\006Height\030\013 \001(\003\022\014\n\004Size\030\014 \001(\003" +
      "\022\021\n\tCheckInfo\030\r \001(\t\022\022\n\nIndexRange\030\016 \001(\t\022" +
      "\021\n\tInitRange\030\017 \001(\t\022\023\n\013PreloadSize\030\020 \001(\003\022" +
      "\026\n\016PreloadMinStep\030\021 \001(\003\022\026\n\016PreloadMaxSte" +
      "p\030\022 \001(\003\022\027\n\017PreloadInterval\030\023 \001(\003\022\024\n\014P2pV" +
      "erifyUrl\030\024 \001(\t\022\020\n\010PlayAuth\030\025 \001(\t\022\022\n\nPlay" +
      "AuthID\030\026 \001(\t\022\020\n\010LogoType\030\027 \001(\t\022\017\n\007Qualit" +
      "y\030\030 \001(\t\"I\n\035VodGetOriginalPlayInfoRequest" +
      "\022\013\n\003Vid\030\001 \001(\t\022\016\n\006Base64\030\002 \001(\t\022\013\n\003Ssl\030\003 \001" +
      "(\t\"\241\001\n\036VodGetOriginalPlayInfoResponse\022>\n" +
      "\020ResponseMetadata\030\001 \001(\0132$.Vcloud.Models." +
      "Base.ResponseMetadata\022?\n\006Result\030\002 \001(\0132/." +
      "Vcloud.Models.Vod.VodGetOriginalPlayInfo" +
      "Result\"\330\001\n\034VodGetOriginalPlayInfoResult\022" +
      "\020\n\010FileType\030\001 \001(\t\022\020\n\010Duration\030\002 \001(\002\022\014\n\004S" +
      "ize\030\003 \001(\003\022\016\n\006Height\030\004 \001(\003\022\r\n\005Width\030\005 \001(\003" +
      "\022\016\n\006Format\030\006 \001(\t\022\r\n\005Codec\030\007 \001(\t\022\017\n\007Bitra" +
      "te\030\010 \001(\002\022\013\n\003Md5\030\t \001(\t\022\023\n\013MainPlayUrl\030\n \001" +
      "(\t\022\025\n\rBackupPlayUrl\030\013 \001(\tB:\n\035com.bytedan" +
      "ceapi.model.commonB\007VodPlayP\001Z\010.;models\240" +
      "\001\001\330\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.bytedanceapi.model.common.Base.getDescriptor(),
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
        new java.lang.String[] { "FileID", "Md5", "FileType", "Format", "Codec", "Definition", "MainPlayUrl", "BackupPlayUrl", "Bitrate", "Width", "Height", "Size", "CheckInfo", "IndexRange", "InitRange", "PreloadSize", "PreloadMinStep", "PreloadMaxStep", "PreloadInterval", "P2PVerifyUrl", "PlayAuth", "PlayAuthID", "LogoType", "Quality", });
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
    com.bytedanceapi.model.common.Base.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
