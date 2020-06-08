package cn.org.dianjiu.core.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * (TRoleMenusReq) Req
 *
 * @author dianjiu
 * @since 2020-05-31 21:51:47
 */
@Data
public class TRoleMenusReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;

    @ApiModelProperty("菜单表id")
    @NotBlank(message = "菜单表id不能为空")
    private Integer menuId;
    @ApiModelProperty("角色表id")
    @NotBlank(message = "角色表id不能为空")
    private Integer roleId;
    @ApiModelProperty("0  -- 未读  1 -- 已用")
    private String status;

}