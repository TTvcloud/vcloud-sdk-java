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
        vodService.setAccessKey("AKLTNDQ2YTRlNTBiYTg1NDcyNmE3MDA1MTUzNzc5MWMwNmI");
        vodService.setSecretKey("1ZOtyBZ89VERZdOfiUrPf24a3tTjRo1XIJbzccVHMrBvZo1jEn60LjClP2t05qWz");

        String space = "james-test";
        String url = "https://stream7.iqilu.com/10339/upload_transcode/202002/18/20200218114723HDu3hhxqIT.mp4";
        try {
            UploadVideoByUrlRequest request = new UploadVideoByUrlRequest();
            request.setSpaceName(space);
            List<URLSet> urlSets = new ArrayList<>();
            URLSet urlSet = new URLSet();
            urlSet.setSourceUrl(url);
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
