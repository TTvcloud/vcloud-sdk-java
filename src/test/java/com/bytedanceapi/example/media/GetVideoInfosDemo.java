package com.bytedanceapi.example.media;

import com.bytedanceapi.model.request.GetVideoInfosRequest;
import com.bytedanceapi.model.request.UpdateVideoInfoRequest;
import com.bytedanceapi.model.response.GetVideoInfosResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class GetVideoInfosDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        String[] vids = new String[]{"vid1", "vid2", "vid3"};
        GetVideoInfosRequest req = new GetVideoInfosRequest();
        req.setVids(vids);

        try {
            GetVideoInfosResponse resp = vodService.getVideoInfos(req);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
