package com.bytedanceapi.example.upload;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedanceapi.helper.Const;
import com.bytedanceapi.model.beans.URLSet;
import com.bytedanceapi.model.request.UploadMediaByUrlRequest;
import com.bytedanceapi.model.request.UploadVideoByUrlRequest;
import com.bytedanceapi.model.response.UploadMediaByUrlResponse;
import com.bytedanceapi.model.response.UploadVideoByUrlResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class UploadMediaByUrlDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        vodService.setAccessKey("your ak");
        vodService.setSecretKey("your sk");

        String space = "your space name";
        String url = "video url";
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
