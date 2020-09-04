package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2020-09-04 15:06:17
 */
@Data 
public class TUser {
    /**
    * 唯一ID
    */
    private Integer id;
    /**
    * 是否禁用登录
    */
    private String loginEnable;
    /**
    * 登录失败次数
    */
    private Integer loginError;
    /**
    * 最后登录时间
    */
    private Date loginLastTime;
    /**
    * 用户头像
    */
    private String userImage;
    /**
    * 显示名称
    */
    private String userDisplayName;
    /**
    * 姓名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 简介
    */
    private String userDesc;
    /**
    * 1 -- 男  0  -- 女
    */
    private String sex;
    /**
    * 手机号
    */
    private String phone;
    /**
    * 邮箱
    */
    private String email;
    /**
    * qq
    */
    private String qq;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;

}