package com.bytedanceapi.example.media;

import com.bytedanceapi.model.common.UpdateVideoInfoRequest;
import com.bytedanceapi.model.common.UpdateVideoInfoResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;
import com.google.protobuf.StringValue;

public class UpdateVideoInfoDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("your ak");
        // vodService.setSecretKey("your sk");

        String vid = "your vid";
        String title = "your title";

        try {
            UpdateVideoInfoRequest.Builder req = UpdateVideoInfoRequest.newBuilder();
            req.setVid(vid);
            //req.setTags(StringValue.of("fasdfa,dff"));
            req.setTitle(StringValue.of(title));
            UpdateVideoInfoResponse resp = vodService.updateVideoInfo(req.build());
            if(resp.getResponseMetadata().hasError()){
                System.out.println("update video info error: " + resp.getResponseMetadata().getError().getMessage());
                return;
            }
            System.out.println(resp.toString());
            System.out.println("update video video success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
