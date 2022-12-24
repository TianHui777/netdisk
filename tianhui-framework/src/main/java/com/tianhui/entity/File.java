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
 * @since 2022-12-24 11:37:08
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("file")
public class File  {
    @TableId
    private Long id;

    
    private String fileName;
    
    private String filePath;
    
    private Long parentId;



}
