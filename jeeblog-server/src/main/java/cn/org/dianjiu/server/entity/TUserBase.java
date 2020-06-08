package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                                    import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TUserBase)实体类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Data 
public class TUserBase {
    /**
    * 唯一ID
    */
    private Integer id;
    /**
    * 姓名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
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
    * 简介
    */
    private String intro;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;

}