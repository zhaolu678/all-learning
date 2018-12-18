package com.luchao.springbootfileupload;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @RequestMapping("/fileupload")
    public String uploadinfo(MultipartFile filename) throws IOException {
        System.out.println("===上传开始===");
        System.out.println("===文件名称："+filename.getOriginalFilename());
        System.out.println("===文件大小："+filename.getSize()/1024/1024+"MB");
        filename.transferTo(new File("d:/"+filename.getOriginalFilename()));
        System.out.println("===上传完成==");
        return "OK";
    }
    @RequestMapping("/test")
    public String test(){
        return "ooookkkk";
    }


}
