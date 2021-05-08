package cn.org.dianjiu.common.pojo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客操作(TBlogResp) Resp
 *
 * @author dianjiu
 * @since 2021-05-08 17:51:01
 */
@Data
public class TBlogResp implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("唯一ID")
    private Integer id;
    @ApiModelProperty("标题")
    private String blogTitle;
    @ApiModelProperty("文章正文")
    private Object blogText;
    @ApiModelProperty("文章摘要")
    private String blogSummary;
    @ApiModelProperty("文章类型(原创，转载)")
    private String blogType;
    @ApiModelProperty("博客分类")
    private String blogSort;
    @ApiModelProperty("文章标签")
    private String blogTags;
    @ApiModelProperty("文章专题")
    private String blogTopic;
    @ApiModelProperty("文章热度（10表示置顶）")
    private Integer blogGrade;
    @ApiModelProperty("文章作者")
    private String blogAuthor;
    @ApiModelProperty("缩略图像")
    private String blogImgs;
    @ApiModelProperty("文章路径")
    private String blogUrl;
    @ApiModelProperty("文章点赞数")
    private Long blogLikes;
    @ApiModelProperty("文章查看数")
    private Long blogViews;
    @ApiModelProperty("是否允许评论（0-不开启 1-开启）")
    private String commentStatus;
    @ApiModelProperty("状态（0-草稿  1-发布）")
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
