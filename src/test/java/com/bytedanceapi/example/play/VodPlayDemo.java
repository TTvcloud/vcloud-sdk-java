package com.bytedanceapi.example.play;

import com.bytedanceapi.model.request.GetOriginVideoPlayRequest;
import com.bytedanceapi.model.request.GetPlayInfoRequest;
import com.bytedanceapi.model.request.GetRedirectPlayRequest;
import com.bytedanceapi.model.response.GetOriginVideoPlayResponse;
import com.bytedanceapi.model.response.GetPlayInfoResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class VodPlayDemo {


    public static void main(String[] args) throws Exception {
        IVodService vodService = VodServiceImpl.getInstance();

        String vid = "your vid";

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        // 1. get play info
        try {
            GetPlayInfoRequest getPlayInfoRequest = new GetPlayInfoRequest();
            getPlayInfoRequest.setVideoId(vid);
            getPlayInfoRequest.setSsl(1L);

            GetPlayInfoResponse resp = vodService.getPlayInfo(getPlayInfoRequest);
            if (resp.getResponseMetadata().getError() != null) {
                System.out.println(resp.getResponseMetadata().getError());
                System.exit(-1);
            }
            System.out.println(resp.getResult().getPlayInfoList().get(0).getMainPlayUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. get origin play info
        GetOriginVideoPlayRequest getOriginVideoPlayRequest = new GetOriginVideoPlayRequest();
        getOriginVideoPlayRequest.setSsl(1);
        getOriginVideoPlayRequest.setVid(vid);
        try {
            GetOriginVideoPlayResponse resp = vodService.getOriginVideoPlayInfo(getOriginVideoPlayRequest);
            if (resp.getResponseMetadata().getError() != null) {
                System.out.println(resp.getResponseMetadata().getError());
                System.exit(-1);
            }
            System.out.println(resp.getOriginPlayData().getMainPlayUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3. get redirect play
        GetRedirectPlayRequest getRedirectPlayRequest = new GetRedirectPlayRequest();
        getRedirectPlayRequest.setVid(vid);
        // set expires time of the redirect play url, defalut is 15min(900),
        // set if if you know the params' meaning exactly.
        getRedirectPlayRequest.setExpires(60);
        try {
            String resp = vodService.getRedirectPlay(getRedirectPlayRequest);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
