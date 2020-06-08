package cn.org.dianjiu.core.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (TBlogTypeReq) Req
 *
 * @author dianjiu
 * @since 2020-05-23 22:06:16
 */
@Data
public class TBlogTypeReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("标签名称")
    @NotBlank(message = "标签名称不能为空")
    private String labelName;
    @ApiModelProperty("0  -- 类型  1 -- 分类   2 -- 标签		3 -- 专题")
    @NotBlank(message = "0  -- 类型  1 -- 分类   2 -- 标签		3 -- 专题不能为空")
    private String type;
    @ApiModelProperty("0  -- 未读  1 -- 已用")
    @NotBlank(message = "0  -- 未读  1 -- 已用不能为空")
    private String status;

}