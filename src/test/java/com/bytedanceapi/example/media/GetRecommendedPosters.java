package com.bytedanceapi.example.media;

import com.bytedanceapi.model.response.GetRecommendedPostersResponse;
import com.bytedanceapi.model.response.GetVideoInfosResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class GetRecommendedPosters {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("your ak");
        // vodService.setSecretKey("your sk");

        String[] vids = new String[]{"vid1", "vid2", "vid3"};

        try {
            GetRecommendedPostersResponse resp = vodService.getRecommendedPostersResponse(vids);
            System.out.println(resp);
            for (String[] uris : resp.getResult().getStoreUriGroups().values()){
                for (String uri : uris) {
                    System.out.println(uri);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
