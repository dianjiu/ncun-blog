package cn.org.dianjiu.core.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (TBlogBaseReq) Req
 *
 * @author dianjiu
 * @since 2020-05-23 22:06:04
 */
@Data
public class TBlogBaseReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("标题")
    @NotBlank(message = "标题不能为空")
    private String articleTitle;
    @ApiModelProperty("文章正文")
    @NotBlank(message = "文章正文不能为空")
    private String articleText;
    @ApiModelProperty("文章摘要")
    @NotBlank(message = "文章摘要不能为空")
    private String articleSummary;
    @ApiModelProperty("文章类型(原创，转载)")
    @NotBlank(message = "文章类型(原创，转载)不能为空")
    private String articleType;
    @ApiModelProperty("博客分类")
    private String articleCategories;
    @ApiModelProperty("文章标签")
    private String articleLabel;
    @ApiModelProperty("文章专题")
    private String articleSpecial;
    @ApiModelProperty("文章热度（10表示置顶）")
    private Integer articleGrade;
    @ApiModelProperty("文章作者")
    private String articleAuthor;
    @ApiModelProperty("缩略图像")
    private String articleImgs;
    @ApiModelProperty("状态（0-草稿  1-发布）")
    private String status;

}