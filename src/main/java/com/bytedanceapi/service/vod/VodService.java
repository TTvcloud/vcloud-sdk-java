package com.bytedanceapi.service.vod;

import java.util.Map;

public interface VodService extends com.bytedanceapi.service.VcloudService {

    public com.bytedanceapi.model.vod.GetPlayInfoResp getPlayInfo(Map<String, String> query) throws Exception;

    public String getPlayAuthToken(Map<String, String> query) throws Exception;

    public com.bytedanceapi.model.vod.StartTranscodeResp startTranscode(com.bytedanceapi.model.vod.StartTranscodeRequest req) throws Exception;

    public String getUploadAuthToken(String space) throws Exception;
}
