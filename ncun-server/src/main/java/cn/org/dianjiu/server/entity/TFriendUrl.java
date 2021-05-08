package cn.org.dianjiu.server.entity;

import java.util.Date;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 友链操作(TFriendUrl)实体类
 *
 * @author dianjiu
 * @since 2021-05-08 17:51:15
 */
@Data
public class TFriendUrl {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 友链名
     */
    private String linkName;
    /**
     * 友链头像
     */
    private String linkImg;
    /**
     * 友链介绍
     */
    private String linkInfo;
    /**
     * 友链地址
     */
    private String linkUrl;
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
