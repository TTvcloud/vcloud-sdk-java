package com.bytedanceapi.example.media;

import com.bytedanceapi.model.common.GetRecommendedPostersRequest;
import com.bytedanceapi.model.common.GetRecPostersResponse;
import com.bytedanceapi.model.common.StoreUriGroup;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class GetRecommendedPosters {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        vodService.setAccessKey("AKLTZDg4ZDlhOTBhYjQxNDdkOTg3MjQwYTQyNDA2NGZiZGU");
        vodService.setSecretKey("j1BGQboVi5502ri5FQytZadS3cPrnvescrWyC/rUDD/h+RHUvf4wpkrKmrUqIzsA");
        vodService.setHost("staging-openapi-boe.byted.org");

        String[] vids = new String[]{"v0c80e6a0000bu02dp6bajs8e253r6k0", "vid2", "vid3"};
        GetRecommendedPostersRequest.Builder req = GetRecommendedPostersRequest.newBuilder();

        try {
            GetRecPostersResponse resp = vodService.getRecommendedPosters(req.build());
            System.out.println(resp.toString());
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
