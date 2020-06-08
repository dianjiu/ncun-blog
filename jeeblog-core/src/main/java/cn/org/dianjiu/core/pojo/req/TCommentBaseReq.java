package cn.org.dianjiu.core.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (TCommentBaseReq) Req
 *
 * @author dianjiu
 * @since 2020-05-23 22:16:22
 */
@Data
public class TCommentBaseReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("博客id")
    @NotBlank(message = "博客id不能为空")
    private Integer blogId;
    @ApiModelProperty("姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;
    @ApiModelProperty("邮箱")
    @NotBlank(message = "邮箱不能为空")
    private String mail;
    @ApiModelProperty("站点")
    @NotBlank(message = "站点不能为空")
    private String site;
    @ApiModelProperty("内容")
    @NotBlank(message = "内容不能为空")
    private String content;
    @ApiModelProperty("父ID")
    private Integer parentId;
    @ApiModelProperty("状态（0-待审核  1-已审核）")
    @NotBlank(message = "状态（0-待审核  1-已审核）不能为空")
    private String status;

}