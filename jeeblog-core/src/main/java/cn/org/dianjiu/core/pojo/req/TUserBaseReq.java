package cn.org.dianjiu.core.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (TUserBaseReq) Req
 *
 * @author dianjiu
 * @since 2020-05-23 22:12:58
 */
@Data
public class TUserBaseReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("姓名")
    @NotBlank(message = "姓名不能为空")
    private String username;
    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;
    @ApiModelProperty("1 -- 男  0  -- 女")
    private String sex;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("qq")
    private String qq;
    @ApiModelProperty("简介")
    private String intro;

}