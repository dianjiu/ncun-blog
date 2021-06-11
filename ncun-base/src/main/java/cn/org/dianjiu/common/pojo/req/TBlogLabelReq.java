package cn.org.dianjiu.common.pojo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章标签(TBlogLabelReq) Req
 *
 * @author dianjiu
 * @since 2021-06-11 11:39:26
 */
@Data
public class TBlogLabelReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("唯一ID")
    private Integer id;
    @ApiModelProperty("标签名称")
    private String labelName;
    @ApiModelProperty("分类路径")
    private String labelUrl;
    @ApiModelProperty("描述")
    private String labelDescribe;
    @ApiModelProperty("0  -- 类型  1 -- 分类   2 -- 标签   3 -- 专题")
    private String labelType;
    @ApiModelProperty("0  -- 未读  1 -- 已用")
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
