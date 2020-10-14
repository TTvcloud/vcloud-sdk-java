package com.bytedanceapi.example.top.upload;

import com.alibaba.fastjson.JSON;
import com.bytedanceapi.model.request.ApplyUploadInfoRequest;
import com.bytedanceapi.model.response.ApplyUploadInfoResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

public class ApplyUploadInfoDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        vodService.setAccessKey("AKLTNDQ2YTRlNTBiYTg1NDcyNmE3MDA1MTUzNzc5MWMwNmI");
        vodService.setSecretKey("1ZOtyBZ89VERZdOfiUrPf24a3tTjRo1XIJbzccVHMrBvZo1jEn60LjClP2t05qWz");

        String space = "james-test";
        try {
            ApplyUploadInfoRequest applyUploadInfoRequest = new ApplyUploadInfoRequest();
            applyUploadInfoRequest.setSpaceName(space);


            ApplyUploadInfoResponse applyUploadInfoResponse = vodService.applyUploadInfo(applyUploadInfoRequest);
            System.out.println(JSON.toJSONString(applyUploadInfoResponse));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
