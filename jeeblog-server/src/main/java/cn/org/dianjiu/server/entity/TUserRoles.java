package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TUserRoles)实体类
 *
 * @author makejava
 * @since 2020-09-04 15:06:17
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
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 0  -- 未读  1 -- 已用
    */
    private String status;

}