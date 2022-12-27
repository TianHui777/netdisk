package com.tianhui.controller;

import com.tianhui.entity.ResponseResult;
import com.tianhui.service.FileService;
import com.tianhui.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    @Autowired
    private UploadService uploadService;
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseResult uploadImg(MultipartFile file, Long currentId) {
        return uploadService.upload(file, currentId);
    }


    @GetMapping("/fileList")
    public ResponseResult fileList(){
        return fileService.fileList();
    }


//    @PostMapping("/video")
//    public ResponseResult uploadVideo(MultipartFile video) {
//        uploadService.uploadVideo();
//    }

}
