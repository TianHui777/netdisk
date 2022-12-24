package com.tianhui.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailVo {

    private Long id;
    //标题
    private String title;
    //文章摘要
    private String summary;

    //所属分类id
    private Long categoryId;

    //所属分类名
    private String categoryName;
    //缩略图
    private String thumbnail;

    //文章内容
    private String content;


    //访问量
    private Long viewCount;

    //@JsonFormat注解，格式化返回的时间格式
    @JsonFormat(timezone = "GMT+8", pattern = "yyy-MM-dd HH:mm:ss")
    private Date createTime;


}
