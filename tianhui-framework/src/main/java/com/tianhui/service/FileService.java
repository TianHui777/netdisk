package com.tianhui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianhui.entity.File;
import com.tianhui.entity.ResponseResult;

/**
 * (File)表服务接口
 *
 * @author makejava
 * @since 2022-12-24 11:37:08
 */
public interface FileService extends IService<File> {

    ResponseResult fileList();
}

