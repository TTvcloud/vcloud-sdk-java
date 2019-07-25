package com.bytedanceapi.example.play;

import com.bytedanceapi.model.request.GetOriginVideoPlayRequest;
import com.bytedanceapi.model.request.GetPlayInfoRequest;
import com.bytedanceapi.model.request.GetRedirectPlayRequest;
import com.bytedanceapi.model.response.GetOriginVideoPlayResponse;
import com.bytedanceapi.model.response.GetPlayInfoResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class VodPlayDemo {


    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        String videoId = "your vid";

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        // get play info
        try {
            GetPlayInfoRequest getPlayInfoRequest = new GetPlayInfoRequest();
            getPlayInfoRequest.setVideoId(videoId);
            getPlayInfoRequest.setSsl(1);

            GetPlayInfoResponse resp = vodService.getPlayInfo(getPlayInfoRequest);
            if (resp.getResponseMetadata().getError() != null) {
                System.out.println(resp.getResponseMetadata().getError());
            }
            System.out.println(resp.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // get origin play info
        GetOriginVideoPlayRequest getOriginVideoPlayRequest = new GetOriginVideoPlayRequest();
        getOriginVideoPlayRequest.setSsl(1);
        getOriginVideoPlayRequest.setVid(videoId);
        try {
            GetOriginVideoPlayResponse resp = vodService.getOriginVideoPlayInfo(getOriginVideoPlayRequest);
            if (resp.getResponseMetadata().getError() != null) {
                System.out.println(resp.getResponseMetadata().getError());
            }
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // get redirect play
        GetRedirectPlayRequest getRedirectPlayRequest = new GetRedirectPlayRequest();
        getRedirectPlayRequest.setVid(videoId);
        try {
            String resp = vodService.getRedirectPlay(getRedirectPlayRequest);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
