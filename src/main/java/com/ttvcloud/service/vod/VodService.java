package com.ttvcloud.service.vod;

import com.ttvcloud.model.vod.GetPlayInfoResp;
import com.ttvcloud.model.vod.StartTranscodeRequest;
import com.ttvcloud.model.vod.StartTranscodeResp;
import com.ttvcloud.service.VcloudService;

import java.util.Map;

public interface VodService extends VcloudService {

    public GetPlayInfoResp getPlayInfo(Map<String, String> query) throws Exception;

    public String getPlayAuthToken(Map<String, String> query) throws Exception;

    public StartTranscodeResp startTranscode(StartTranscodeRequest req) throws Exception;

    public String getUploadAuthToken(String space) throws Exception;
}
