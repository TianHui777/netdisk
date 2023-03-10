package com.tianhui.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.tianhui.entity.File;
import com.tianhui.entity.ResponseResult;
import com.tianhui.service.FileService;
import com.tianhui.service.UploadService;
import com.tianhui.utils.PathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/*
    Oss文件上传实现服务类
 */
@Service
public class OssUploadService implements UploadService {

    @Autowired
    FileService fileService;

    /*
        图片上传
     */
    @Override
    public ResponseResult upload(MultipartFile file, Long parentId, String type) {
        //判断文件类型
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //对原始文件名进行判断
//        if (!originalFilename.endsWith(".png")) {
//            throw new SystemException(AppHttpCodeEnum.FILE_TYPE_ERROR);
//        }
        //如果判断通过上传文件到OSS
        String filePath = PathUtils.generateFilePath(originalFilename);
        String url = uploadOss(file, filePath);//  2099/2/3/wqeqeqe.png

        fileService.save(new File(null, originalFilename, parentId, type, url, 0));
        return ResponseResult.okResult(url);
    }

    private String uploadOss(MultipartFile file, String filePath) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = filePath;
        //...生成上传凭证，然后准备上传
        String accessKey = "mp9Xz3FL6ZPZ-Gd5oCigO0aKRAdtpp0_1ntCJ-ym";
        String secretKey = "lBqqHpKEmUsVVuzcT5FFpKg-FqGtBa6iaFga4Ltj";
        String bucket = "pictures-files";
        try {
            InputStream inputStream = file.getInputStream();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(inputStream, key, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                return "http://rn4xtwrtm.hn-bkt.clouddn.com/" + key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return "www";
    }

}
