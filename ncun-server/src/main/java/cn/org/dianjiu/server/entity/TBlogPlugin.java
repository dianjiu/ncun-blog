package cn.org.dianjiu.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 插件操作(TBlogPlugin)实体类
 *
 * @author dianjiu
 * @since 2021-06-11 11:39:27
 */
@Data
public class TBlogPlugin {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 插件名(url)
     */
    private String pluginName;
    /**
     * 插件描述
     */
    private String pluginDescribe;
    /**
     * 插件预览图
     */
    private String pluginImg;
    /**
     * 状态 1 -- 生效  0  -- 弃用
     */
    private String status;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;
    /**
     * 更新人
     */
    private String updatedBy;

}
