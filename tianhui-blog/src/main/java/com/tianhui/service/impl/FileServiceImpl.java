package com.tianhui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
 * @since 2022-12-31 10:57:41
 */
@Service("fileService")
public class FileServiceImpl extends ServiceImpl<FileDao, File> implements FileService {

    /*
        根据当前目前Id获取所有文件
     */
    @Override
    public ResponseResult fileList(Long fileId) {
        // fileId==-1,获取根目录下所有文件
//        if (fileId == -1) {
//            LambdaQueryWrapper<File> queryWrapper = new LambdaQueryWrapper<>();
//            queryWrapper.eq(File::getParentId, fileId);
//            List<File> rootFiles = list(queryWrapper);
//            return ResponseResult.okResult(rootFiles);
//        }

        // fileId!=-1,以该文件为上级目录所有文件

        LambdaQueryWrapper<File> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(File::getParentId, fileId);
        List<File> rootFiles = list(queryWrapper);
        return ResponseResult.okResult(rootFiles);


    }
}

