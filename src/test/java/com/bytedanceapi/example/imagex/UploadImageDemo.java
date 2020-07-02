package com.bytedanceapi.example.imagex;

import com.bytedanceapi.model.request.ApplyUploadRequest;
import com.bytedanceapi.model.response.CommitUploadResponse;
import com.bytedanceapi.service.imagex.IImageXService;
import com.bytedanceapi.service.imagex.impl.ImageXServiceImpl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UploadImageDemo {
    public static void main(String[] args) {
        // default region cn-north-1, for other region, call ImageXServiceImpl.getInstance(region)
        IImageXService service = ImageXServiceImpl.getInstance();

        // call below method if you dont set ak and sk in ～/.vcloud/config
        service.setAccessKey("ak");
        service.setSecretKey("sk");

        ApplyUploadRequest request = new ApplyUploadRequest();
        request.setServiceId("imagex service id");

        try {
            List<byte[]> datas = new ArrayList<>();
            datas.add(Files.readAllBytes(Paths.get("image file path 1")));
            datas.add(Files.readAllBytes(Paths.get("image file path 2")));

            CommitUploadResponse response = service.uploadImages(request, datas);
            System.out.println(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
