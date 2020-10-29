package com.bytedanceapi.example.media;

import com.bytedanceapi.model.common.GetRecommendedPostersRequest;
import com.bytedanceapi.model.common.GetRecPostersResponse;
import com.bytedanceapi.model.common.StoreUriGroup;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

import java.util.Arrays;
import java.util.List;

public class GetRecommendedPosters {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("your ak");
        // vodService.setSecretKey("your sk");

        GetRecommendedPostersRequest.Builder req = GetRecommendedPostersRequest.newBuilder();
        req.setVids("vid1,vid2");

        try {
            GetRecPostersResponse resp = vodService.getRecommendedPosters(req.build());
            if(resp.getResponseMetadata().hasError()){
                System.out.println("get recommended posters error: " + resp.getResponseMetadata().getError().getMessage());
                return;
            }
            System.out.println(resp.getResult().getNotExistVidsList());
            for (StoreUriGroup uriInfo : resp.getResult().getStoreUriGroupsList()){
                System.out.println(uriInfo.getVid());
                for (String uri : uriInfo.getStoreUrisList()) {
                    System.out.println(uri);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
