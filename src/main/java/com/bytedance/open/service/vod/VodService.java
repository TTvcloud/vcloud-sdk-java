package com.bytedance.open.service.vod;

import java.util.Map;

public interface VodService extends com.bytedance.open.service.VcloudService {

    public com.bytedance.open.model.vod.GetPlayInfoResp getPlayInfo(Map<String, String> query) throws Exception;

    public String getPlayAuthToken(Map<String, String> query) throws Exception;

    public com.bytedance.open.model.vod.StartTranscodeResp startTranscode(com.bytedance.open.model.vod.StartTranscodeRequest req) throws Exception;

    public String getUploadAuthToken(String space) throws Exception;
}
