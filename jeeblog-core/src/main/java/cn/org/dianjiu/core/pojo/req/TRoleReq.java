package cn.org.dianjiu.core.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * (TRoleReq) Req
 *
 * @author dianjiu
 * @since 2020-05-31 21:51:30
 */
@Data
public class TRoleReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("角色代码")
    @NotBlank(message = "角色代码不能为空")
    private String roleCode;
    @ApiModelProperty("角色名称")
    @NotBlank(message = "角色名称不能为空")
    private String roleName;
    @ApiModelProperty("0  -- 未读  1 -- 已用")
    private String status;

}