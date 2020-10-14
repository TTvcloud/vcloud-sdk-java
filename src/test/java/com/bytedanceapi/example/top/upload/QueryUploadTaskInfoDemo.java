package com.bytedanceapi.example.top.upload;

import com.alibaba.fastjson.JSON;
import com.bytedanceapi.model.beans.URLSet;
import com.bytedanceapi.model.request.QueryUploadTaskInfoRequest;
import com.bytedanceapi.model.request.UploadVideoByUrlRequest;
import com.bytedanceapi.model.response.QueryUploadTaskInfoResponse;
import com.bytedanceapi.model.response.UploadVideoByUrlResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryUploadTaskInfoDemo {

    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        vodService.setAccessKey("AKLTNDQ2YTRlNTBiYTg1NDcyNmE3MDA1MTUzNzc5MWMwNmI");
        vodService.setSecretKey("1ZOtyBZ89VERZdOfiUrPf24a3tTjRo1XIJbzccVHMrBvZo1jEn60LjClP2t05qWz");

        try {
            QueryUploadTaskInfoRequest request = new QueryUploadTaskInfoRequest();
            String jobId = "5f4f61d887664b388d03877f481b44d8";

            List<String> jobIds = Arrays.asList(jobId);
            request.setJobIds(String.join(",", jobIds));

            QueryUploadTaskInfoResponse queryUploadTaskInfoResponse = vodService.queryUploadTaskInfo(request);
            System.out.println(JSON.toJSONString(queryUploadTaskInfoResponse));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
