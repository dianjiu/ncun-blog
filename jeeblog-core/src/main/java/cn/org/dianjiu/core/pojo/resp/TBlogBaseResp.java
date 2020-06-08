package cn.org.dianjiu.core.pojo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TBlogBaseResp) Resp
 *
 * @author dianjiu
 * @since 2020-05-23 22:06:05
 */
@Data
public class TBlogBaseResp implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("唯一ID")
    private Integer id;
    @ApiModelProperty("标题")
    private String articleTitle;
    @ApiModelProperty("文章正文")
    private String articleText;
    @ApiModelProperty("文章摘要")
    private String articleSummary;
    @ApiModelProperty("文章类型(原创，转载)")
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
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}