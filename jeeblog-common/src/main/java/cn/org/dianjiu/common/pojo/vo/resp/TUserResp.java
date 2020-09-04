package cn.org.dianjiu.common.pojo.vo.resp;

import java.util.Date;
import lombok.Data;
                import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 * (TUserResp) Resp
 *
 * @author makejava
 * @since 2020-09-04 15:06:17
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
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date createTime;
        @ApiModelProperty("更新时间")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date updateTime;

}