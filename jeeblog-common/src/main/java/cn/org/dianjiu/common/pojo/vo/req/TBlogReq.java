package cn.org.dianjiu.common.pojo.vo.req;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * (TBlogReq) Req
 *
 * @author makejava
 * @since 2020-09-04 15:06:13
 */
@Data 
public class TBlogReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
        @ApiModelProperty("唯一ID")
            private Integer id;
        @ApiModelProperty("标题")
            private String articleTitle;
        @ApiModelProperty("文章正文")
            private Object articleText;
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
        @ApiModelProperty("文章路径")
            private String articleUrl;
        @ApiModelProperty("文章点赞数")
            private Long articleLikes;
        @ApiModelProperty("文章查看数")
            private Long articleViews;
        @ApiModelProperty("是否允许评论（0-不开启 1-开启）")
            private String commentStatus;
        @ApiModelProperty("状态（0-草稿  1-发布）")
            private String status;
        @ApiModelProperty("创建时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date createTime;
        @ApiModelProperty("更新时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date updateTime;

}