package cn.org.dianjiu.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * (TBlogTheme)实体类
 *
 * @author makejava
 * @since 2020-09-05 21:30:19
 */
@Data
public class TBlogTheme {
    private Integer id;
    /**
     * 主题名(url)
     */
    private String themeName;
    /**
     * 主题描述
     */
    private String themeDescribe;
    /**
     * 主题预览图
     */
    private String themeImg;
    /**
     * 状态 1 -- 生效  0  -- 弃用
     */
    private String status;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}