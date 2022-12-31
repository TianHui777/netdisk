package com.tianhui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianhui.entity.File;
import com.tianhui.entity.ResponseResult;

/**
 * (File)表服务接口
 *
 * @author makejava
 * @since 2022-12-31 10:57:40
 */
public interface FileService extends IService<File> {

    /*
        根据当前目录Id获取所有文件
     */
    ResponseResult fileList(Long fileId);
}

