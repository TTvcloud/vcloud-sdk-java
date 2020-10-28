package com.bytedanceapi.example.top.upload;

import com.alibaba.fastjson.JSON;
import com.bytedanceapi.model.beans.Functions;
import com.bytedanceapi.model.beans.FunctionsSnapshotInput;
import com.bytedanceapi.model.response.CommitUploadInfoResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class UploadVideoDemo {

    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        vodService.setAccessKey("your ak");
        vodService.setSecretKey("your sk");

        String space = "your space";
        String filePath = "file path";
        try {
            List<Functions> functionsList = new ArrayList<>();
            Functions getMetaFunc = Functions.GetMetaFunction();
            functionsList.add(getMetaFunc);

            Functions snapShotFunc = Functions.SnapShotFunction(2.3);
            functionsList.add(snapShotFunc);

            CommitUploadInfoResponse commitUploadInfoResponse = vodService.uploadVideoToB(space, filePath, JSON.toJSONString(functionsList), "");
            System.out.println(JSON.toJSONString(commitUploadInfoResponse));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

}
