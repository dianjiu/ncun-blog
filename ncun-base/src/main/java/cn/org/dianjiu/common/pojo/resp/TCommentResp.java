package cn.org.dianjiu.common.pojo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论操作(TCommentResp) Resp
 *
 * @author dianjiu
 * @since 2021-06-11 11:39:03
 */
@Data
public class TCommentResp implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("唯一ID")
    private Integer id;
    @ApiModelProperty("博客id")
    private Integer blogId;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("邮箱")
    private String mail;
    @ApiModelProperty("站点")
    private String site;
    @ApiModelProperty("内容")
    private String content;
    @ApiModelProperty("父ID")
    private Integer parentId;
    @ApiModelProperty("状态（0-待审核  1-已审核）")
    private String status;
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
