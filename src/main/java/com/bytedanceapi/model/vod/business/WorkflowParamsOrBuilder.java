// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vod/business/vod_workflow.proto

package com.bytedanceapi.model.vod.business;

public interface WorkflowParamsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Vcloud.Models.Vod.WorkflowParams)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 覆盖参数
   * </pre>
   *
   * <code>.Vcloud.Models.Vod.OverrideParams OverrideParams = 1;</code>
   * @return Whether the overrideParams field is set.
   */
  boolean hasOverrideParams();
  /**
   * <pre>
   * 覆盖参数
   * </pre>
   *
   * <code>.Vcloud.Models.Vod.OverrideParams OverrideParams = 1;</code>
   * @return The overrideParams.
   */
  OverrideParams getOverrideParams();
  /**
   * <pre>
   * 覆盖参数
   * </pre>
   *
   * <code>.Vcloud.Models.Vod.OverrideParams OverrideParams = 1;</code>
   */
  OverrideParamsOrBuilder getOverrideParamsOrBuilder();

  /**
   * <pre>
   * 条件变量
   * </pre>
   *
   * <code>map&lt;string, bool&gt; Condition = 2;</code>
   */
  int getConditionCount();
  /**
   * <pre>
   * 条件变量
   * </pre>
   *
   * <code>map&lt;string, bool&gt; Condition = 2;</code>
   */
  boolean containsCondition(
      java.lang.String key);
  /**
   * Use {@link #getConditionMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.Boolean>
  getCondition();
  /**
   * <pre>
   * 条件变量
   * </pre>
   *
   * <code>map&lt;string, bool&gt; Condition = 2;</code>
   */
  java.util.Map<java.lang.String, java.lang.Boolean>
  getConditionMap();
  /**
   * <pre>
   * 条件变量
   * </pre>
   *
   * <code>map&lt;string, bool&gt; Condition = 2;</code>
   */

  boolean getConditionOrDefault(
      java.lang.String key,
      boolean defaultValue);
  /**
   * <pre>
   * 条件变量
   * </pre>
   *
   * <code>map&lt;string, bool&gt; Condition = 2;</code>
   */

  boolean getConditionOrThrow(
      java.lang.String key);
}
