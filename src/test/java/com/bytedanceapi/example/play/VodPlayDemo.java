package com.bytedanceapi.example.play;

import com.bytedanceapi.model.common.VodGetOriginalPlayInfoRequest;
import com.bytedanceapi.model.common.VodGetOriginalPlayInfoResponse;
import com.bytedanceapi.model.common.VodGetPlayInfoRequest;
import com.bytedanceapi.model.common.VodGetPlayInfoResponse;
import com.bytedanceapi.model.request.GetRedirectPlayRequest;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class VodPlayDemo {


    public static void main(String[] args) throws Exception {
        IVodService vodService = VodServiceImpl.getInstance();

        String vid = "v0c2c369007abu04ru8riko30uo9n73g";

        // call below method if you dont set ak and sk in ～/.vcloud/config
//         vodService.setAccessKey("");
//         vodService.setSecretKey("");

        // 1. get play info
        try {
            VodGetPlayInfoRequest.Builder reqBuilder = VodGetPlayInfoRequest.newBuilder();
            reqBuilder.setVid(vid);
            reqBuilder.setSsl("1");

            VodGetPlayInfoResponse resp = vodService.getPlayInfo(reqBuilder.build());
            if (resp.getResponseMetadata().hasError()) {
                System.out.println(resp.getResponseMetadata().getError());
                System.exit(-1);
            }
            System.out.println(resp.getResult().getPlayInfoList(0).getMainPlayUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. get origin play info

        try {
            VodGetOriginalPlayInfoRequest.Builder reqBuilder = VodGetOriginalPlayInfoRequest.newBuilder();
            reqBuilder.setSsl("1");
            reqBuilder.setVid(vid);
            VodGetOriginalPlayInfoResponse resp = vodService.getOriginalPlayInfo(reqBuilder.build());
            if (resp.getResponseMetadata().hasError()) {
                System.out.println(resp.getResponseMetadata().getError());
                System.exit(-1);
            }
            System.out.println(resp.getResult().getMainPlayUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
