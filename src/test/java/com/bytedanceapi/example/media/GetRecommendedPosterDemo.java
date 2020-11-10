package com.bytedanceapi.example.media;

import com.bytedanceapi.model.vod.business.VodStoreUriGroup;
import com.bytedanceapi.model.vod.request.VodGetRecommendedPosterRequest;
import com.bytedanceapi.model.vod.response.VodGetRecommendedPosterResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class GetRecommendedPosterDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("your ak");
        // vodService.setSecretKey("your sk");

        VodGetRecommendedPosterRequest.Builder req = VodGetRecommendedPosterRequest.newBuilder();
        req.setVids("vid1,vid2,vid3");

        try {
            VodGetRecommendedPosterResponse resp = vodService.getRecommendedPoster(req.build());
            if(resp.getResponseMetadata().hasError()){
                System.out.println("get recommended posters error: " + resp.getResponseMetadata().getError().getMessage());
                return;
            }
            System.out.println(resp.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
