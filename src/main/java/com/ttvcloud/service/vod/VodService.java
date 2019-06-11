package com.ttvcloud.service.vod;

import com.ttvcloud.model.vod.StartTranscodeRequest;
import com.ttvcloud.model.vod.VodResponse;
import com.ttvcloud.service.VcloudService;

import java.util.Map;

public interface VodService extends VcloudService {

    public VodResponse getPlayInfo(Map<String, String> query);

    public String getPlayAuthToken(Map<String, String> query) throws Exception;

    public VodResponse startTranscode(StartTranscodeRequest req);
}
