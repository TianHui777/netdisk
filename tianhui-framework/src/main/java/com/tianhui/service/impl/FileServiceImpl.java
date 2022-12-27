package com.tianhui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianhui.dao.FileDao;
import com.tianhui.entity.File;
import com.tianhui.entity.ResponseResult;
import com.tianhui.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (File)表服务实现类
 *
 * @author makejava
 * @since 2022-12-24 11:37:08
 */
@Service("fileService")
public class FileServiceImpl extends ServiceImpl<FileDao, File> implements FileService {

    @Override
    public ResponseResult fileList() {
        List<File> files = list();
        return ResponseResult.okResult(files);
    }
}

