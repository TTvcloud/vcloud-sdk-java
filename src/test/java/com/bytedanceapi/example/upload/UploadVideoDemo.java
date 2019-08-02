package com.bytedanceapi.example.upload;

import com.bytedanceapi.helper.Const;
import com.bytedanceapi.model.beans.Functions;
import com.bytedanceapi.model.beans.FunctionsSnapshotInput;
import com.bytedanceapi.model.response.CommitUploadResponse;
import com.bytedanceapi.service.vod.IVodService;
import com.bytedanceapi.service.vod.impl.VodServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class UploadVideoDemo {
    public static void main(String[] args) {
        IVodService vodService = VodServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        // vodService.setAccessKey("");
        // vodService.setSecretKey("");

        String space = "your spaceName";
        String filePath = "your video file path";
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

            CommitUploadResponse commitUploadResponse = vodService.uploadVideo(space, filePath, Const.FILE_TYPE_VIDEO, functionsList);
            System.out.println(commitUploadResponse);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }


}
