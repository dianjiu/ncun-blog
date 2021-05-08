package cn.org.dianjiu.server.entity;

import java.util.Date;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 角色菜单操作(TRoleMenus)实体类
 *
 * @author dianjiu
 * @since 2021-05-08 17:51:20
 */
@Data
public class TRoleMenus {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 菜单表id
     */
    private Integer menuId;
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
