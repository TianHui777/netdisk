package com.tianhui.controller;


import com.tianhui.entity.ResponseResult;
import com.tianhui.service.FileService;
import com.tianhui.service.impl.OssUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

@Api(value = "文件管理", tags = "文件操作相关接口")
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
    @ApiOperation("文件上传接口")
    @PostMapping("/upload")
    public ResponseResult upload(
            @ApiParam(name = "file", value = "需要上传的文件", required = true)
            MultipartFile file,
            @ApiParam(name = "parentId", value = "该文件的父目录", required = true)
            Long parentId,
            @ApiParam(name = "type", value = "文件类型:file或者folder", required = true)
            String type) {
        return ossUploadService.upload(file, parentId, type);
    }

    /*
        根据当前目录Id获取所有文件列表
     */
    @ApiOperation(value = "获取当前目录下所有文件（夹）")
    @GetMapping("/fileList")
    public ResponseResult fileList(
            @ApiParam(name = "fileId", value = "当前目录的id", required = true)
            Long fileId) {
        return fileService.fileList(fileId);
    }


}

