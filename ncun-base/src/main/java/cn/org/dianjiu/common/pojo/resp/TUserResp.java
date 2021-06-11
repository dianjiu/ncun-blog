package cn.org.dianjiu.common.pojo.resp;

import java.util.Date;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 用户操作(TUserResp) Resp
 *
 * @author dianjiu
 * @since 2021-06-11 11:38:12
 */
@Data
public class TUserResp implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("唯一ID")
    private Integer id;
    @ApiModelProperty("是否禁用登录")
    private String loginEnable;
    @ApiModelProperty("登录失败次数")
    private Integer loginError;
    @ApiModelProperty("最后登录时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginLastTime;
    @ApiModelProperty("用户头像")
    private String userImage;
    @ApiModelProperty("显示名称")
    private String userDisplayName;
    @ApiModelProperty("姓名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("简介")
    private String userDesc;
    @ApiModelProperty("1 -- 男  0  -- 女")
    private String sex;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("qq")
    private String qq;
    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    @ApiModelProperty("创建人")
    private String createdBy;
    @ApiModelProperty("更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;
    @ApiModelProperty("更新人")
    private String updatedBy;

}
