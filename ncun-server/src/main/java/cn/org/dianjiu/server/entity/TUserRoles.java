package cn.org.dianjiu.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * (TUserRoles)实体类
 *
 * @author makejava
 * @since 2020-09-05 21:33:29
 */
@Data
public class TUserRoles {
    /**
     * 主键，自增长
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
    /**
     * 0  -- 未读  1 -- 已用
     */
    private String status;

}