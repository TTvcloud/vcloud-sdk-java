package com.bytedanceapi.example.top.upload;

import com.alibaba.fastjson.JSON;
import com.bytedanceapi.model.beans.URLSet;
import com.bytedanceapi.model.request.UploadVideoByUrlRequest;
import com.bytedanceapi.model.response.UploadVideoByUrlResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class UploadVideoByUrlDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        vodService.setAccessKey("your ak");
        vodService.setSecretKey("your sk");

        String space = "your space";
        String url = "video url";
        try {
            UploadVideoByUrlRequest request = new UploadVideoByUrlRequest();
            request.setSpaceName(space);
            List<URLSet> urlSets = new ArrayList<>();
            URLSet urlSet = URLSet.builder()
                    .SourceUrl(url)
                    .CallbackArgs("my callback")
                    .build();

            urlSets.add(urlSet);

            request.setURLSets(JSON.toJSONString(urlSets));

            UploadVideoByUrlResponse uploadVideoByUrlResponse = vodService.uploadVideoByUrl(request);
            System.out.println(JSON.toJSONString(uploadVideoByUrlResponse));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
