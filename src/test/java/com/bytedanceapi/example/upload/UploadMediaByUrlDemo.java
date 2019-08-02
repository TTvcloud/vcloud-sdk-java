package com.bytedanceapi.example.upload;

import com.bytedanceapi.helper.Const;
import com.bytedanceapi.model.request.UploadMediaByUrlRequest;
import com.bytedanceapi.model.response.UploadMediaByUrlResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class UploadMediaByUrlDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        String space = "your spaceName";
        String url = "your url";
        try {
            UploadMediaByUrlRequest uploadMediaByUrlRequest = new UploadMediaByUrlRequest();
            uploadMediaByUrlRequest.setSpaceName(space);
            uploadMediaByUrlRequest.setFormat(Const.UPLOAD_FORMAT_MP4);
            List<String> list = new ArrayList<>();
            list.add(url);
            uploadMediaByUrlRequest.setSourceUrls(list);

            UploadMediaByUrlResponse uploadMediaByUrlResponse = vodService.uploadMediaByUrl(uploadMediaByUrlRequest);
            if (uploadMediaByUrlResponse.getResponseMetadata() != null || uploadMediaByUrlResponse.getResult().getCode() != 0) {
                System.exit(-1);
            }
            System.out.println(uploadMediaByUrlResponse);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
