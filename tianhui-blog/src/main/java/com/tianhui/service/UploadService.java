package com.tianhui.service;

import com.tianhui.entity.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/*
    文件上传接口
 */
public interface UploadService {

    /*
        文件上传
     */
    ResponseResult upload(MultipartFile file, Long parentId,String type);

}
