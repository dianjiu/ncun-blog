package cn.org.dianjiu.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户角色操作(TUserRoles)实体类
 *
 * @author dianjiu
 * @since 2021-05-08 17:51:27
 */
@Data
public class TUserRoles {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 用户表id
     */
    private Integer userId;
    /**
     * 角色表id
     */
    private Integer roleId;
    /**
     * 0  -- 弃用  1 -- 启用
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
