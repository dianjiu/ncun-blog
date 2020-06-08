package cn.org.dianjiu.core.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (TMenuReq) Req
 *
 * @author dianjiu
 * @since 2020-05-31 21:51:02
 */
@Data
public class TMenuReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;

    @ApiModelProperty("菜单url（Controller 请求路径）")
    @NotBlank(message = "菜单url（Controller 请求路径）不能为空")
    private String menuUrl;
    @ApiModelProperty("菜单名称")
    @NotBlank(message = "菜单名称不能为空")
    private String menuName;
    @ApiModelProperty("0  -- 未读  1 -- 已用")
    private String status;

}