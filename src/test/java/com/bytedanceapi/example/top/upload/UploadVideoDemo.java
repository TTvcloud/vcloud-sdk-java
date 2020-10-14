package com.bytedanceapi.example.top.upload;

import com.alibaba.fastjson.JSON;
import com.bytedanceapi.helper.Const;
import com.bytedanceapi.model.beans.Functions;
import com.bytedanceapi.model.beans.FunctionsSnapshotInput;
import com.bytedanceapi.model.response.CommitUploadInfoResponse;
import com.bytedanceapi.model.response.CommitUploadResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class UploadVideoDemo {

    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        vodService.setAccessKey("AKLTNDQ2YTRlNTBiYTg1NDcyNmE3MDA1MTUzNzc5MWMwNmI");
        vodService.setSecretKey("1ZOtyBZ89VERZdOfiUrPf24a3tTjRo1XIJbzccVHMrBvZo1jEn60LjClP2t05qWz");

        String space = "james-test";
        String filePath = "/Users/bytedance/Downloads/objects.mp4";
        try {
            List<Functions> functionsList = new ArrayList<>();
            Functions getMetaFunc = new Functions();
            getMetaFunc.setName("GetMeta");
            functionsList.add(getMetaFunc);

            Functions snapShotFunc = new Functions();
            snapShotFunc.setName("Snapshot");
            FunctionsSnapshotInput functionsSnapshotInput = new FunctionsSnapshotInput();
            functionsSnapshotInput.setSnapshotTime(2.3);
            snapShotFunc.setInput(functionsSnapshotInput);
            functionsList.add(snapShotFunc);

            CommitUploadInfoResponse commitUploadInfoResponse = vodService.uploadVideoToB(space, filePath, JSON.toJSONString(functionsList), "");
            System.out.println(JSON.toJSONString(commitUploadInfoResponse));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

}
