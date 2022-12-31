package com.tianhui.entity;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (File)表实体类
 *
 * @author makejava
 * @since 2022-12-31 10:57:40
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("file")
public class File {
    @TableId
    private Long id;


    private String fileName;

    private Long parentId;
    //类型：file/folder
    private String type;

    private String fileUrl;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

}
