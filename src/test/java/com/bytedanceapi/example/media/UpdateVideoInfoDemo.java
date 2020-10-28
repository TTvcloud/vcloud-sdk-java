package com.bytedanceapi.example.media;

import com.bytedanceapi.model.request.UpdateVideoInfoRequest;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class UpdateVideoInfoDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("your ak");
        // vodService.setSecretKey("your sk");

        String vid = "your vid";
        String title = "your title";

        try {
            UpdateVideoInfoRequest req = new UpdateVideoInfoRequest();
            req.setVid(vid);
            req.setTags(""); //置空
            req.setTitle(title);
            vodService.updateVideoInfo(req);
            System.out.println("update video video success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}