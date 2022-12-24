package com.tianhui.controller;

import com.tianhui.entity.ResponseResult;
import com.tianhui.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping
    public ResponseResult uploadImg(MultipartFile file, Long currentId) {
        return uploadService.upload(file, currentId);
    }

//    @PostMapping("/video")
//    public ResponseResult uploadVideo(MultipartFile video) {
//        uploadService.uploadVideo();
//    }

}
