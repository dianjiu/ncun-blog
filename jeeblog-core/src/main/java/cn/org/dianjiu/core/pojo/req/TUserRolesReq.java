package cn.org.dianjiu.core.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * (TUserRolesReq) Req
 *
 * @author dianjiu
 * @since 2020-05-31 21:52:04
 */
@Data
public class TUserRolesReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("用户表id")
    @NotBlank(message = "用户表id不能为空")
    private Integer userId;
    @ApiModelProperty("角色表id")
    @NotBlank(message = "角色表id不能为空")
    private Integer roleId;
    @ApiModelProperty("0  -- 未读  1 -- 已用")
    private String status;

}