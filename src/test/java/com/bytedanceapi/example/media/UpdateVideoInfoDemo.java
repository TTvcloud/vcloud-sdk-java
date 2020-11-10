package com.bytedanceapi.example.media;

import com.bytedanceapi.model.vod.request.VodUpdateVideoInfoRequest;
import com.bytedanceapi.model.vod.request.VodUpdateVideoPublishStatusRequest;
import com.bytedanceapi.model.vod.response.VodUpdateVideoInfoResponse;
import com.bytedanceapi.model.vod.response.VodUpdateVideoPublishStatusResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;
import com.google.protobuf.StringValue;

public class UpdateVideoInfoDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        String vid = "vid";
        String Title = "title";
        String Tags = "tag1,tag2";

        try {
            VodUpdateVideoInfoRequest.Builder req = VodUpdateVideoInfoRequest.newBuilder();
            req.setVid(vid);
            req.setTitle(StringValue.of(Title));
            req.setTags(StringValue.of(Tags));

            VodUpdateVideoInfoResponse resp = vodService.updateVideoInfo(req.build());
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
