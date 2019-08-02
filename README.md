## TTVcloud SDK for Java

### Maven依赖
```
<dependency>
    <groupId>com.bytedanceapi</groupId>
    <artifactId>vcloud-sdk-java</artifactId>
    <version>0.0.4</version>
</dependency>
```

### AK/SK设置
- 在代码里显示调用VodService的方法setAccessKey/setSecretKey

- 在当前环境变量中分别设置 VCLOUD_ACCESSKEY="your ak"  VCLOUD_SECRETKEY = "your sk"

- json格式放在～/.vcloud/config中，格式为：{"ak":"your ak","sk":"your sk"}

以上优先级依次降低，建议在代码里显示设置，以便问题排查

### API

#### 上传


上传视频包括 [applyUpload](https://open.bytedance.com/docs/4/2915/) 和 [commitUpload](https://open.bytedance.com/docs/4/2916/) 两步

上传封面图包括 [applyUpload](https://open.bytedance.com/docs/4/2915/) 和 [modifyVideoInfo](https://open.bytedance.com/docs/4/4367/) 两步


为方便用户使用，封装方法 uploadVideo 和 uploadPoster， 一步上传


#### 转码
[startTranscode](https://open.bytedance.com/docs/4/1670/)


#### 发布
[setVideoPublishStatus](https://open.bytedance.com/docs/4/4709/)


#### 播放：
[getPlayInfo](https://open.bytedance.com/docs/4/2918/)

[getOriginVideoPlayInfo](https://open.bytedance.com/docs/4/11148/)

[getRedirectPlay](https://open.bytedance.com/docs/4/9205/)

#### 封面图:
[getPosterUrl]()


#### 更多示例参见
src/test/java/com/bytedanceapi/example



###Change log

#### 0.0.4
- 去掉image X 相关
- 增加封面图上传接口
- getUploadAuthToken/getPlayAuthToken/RedirectPlay支持X-Amz-Expires参数
- 代码格式优化