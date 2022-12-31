package com.tianhui.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;

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
public class FileVo {
    @TableId
    private Long id;


    private String fileName;

    private Long parentId;
    //类型：file/folder
    private String type;

    private String fileUrl;

}