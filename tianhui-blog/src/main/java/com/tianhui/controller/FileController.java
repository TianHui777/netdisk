package com.tianhui.controller;


import com.tianhui.entity.ResponseResult;
import com.tianhui.service.FileService;
import com.tianhui.service.impl.OssUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * (File)表控制层
 *
 * @author makejava
 * @since 2022-12-31 10:57:40
 */
@RestController
@RequestMapping("/file")
public class FileController {
    /**
     * 服务对象
     */
    @Resource
    private FileService fileService;
    @Autowired
    OssUploadService ossUploadService;

    /*
        上传文件
     */
    @PostMapping("/upload")
    public ResponseResult upload(MultipartFile file, Long parentId, String type) {
        return ossUploadService.upload(file, parentId, type);
    }

    /*
        根据当前目录Id获取所有文件列表
     */
    @GetMapping("/fileList")
    public ResponseResult fileList(Long fileId) {
        return fileService.fileList(fileId);
    }


}

