package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TRole)实体类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Data 
public class TRole {
    /**
    * 主键，自增长
    */
    private Integer id;
    /**
    * 角色代码
    */
    private String roleCode;
    /**
    * 角色名称
    */
    private String roleName;
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