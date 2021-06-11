package cn.org.dianjiu.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 博客操作(TBlog)实体类
 *
 * @author dianjiu
 * @since 2021-06-11 11:39:23
 */
@Data
public class TBlog {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 标题
     */
    private String blogTitle;
    /**
     * 文章正文
     */
    private Object blogText;
    /**
     * 文章摘要
     */
    private String blogSummary;
    /**
     * 文章类型(0-原创，1-转载)
     */
    private String blogType;
    /**
     * 博客分类
     */
    private String blogSort;
    /**
     * 文章标签
     */
    private String blogTags;
    /**
     * 文章专题
     */
    private String blogTopic;
    /**
     * 文章热度（10表示置顶）
     */
    private Integer blogGrade;
    /**
     * 文章作者
     */
    private String blogAuthor;
    /**
     * 缩略图像
     */
    private String blogImgs;
    /**
     * 文章路径
     */
    private String blogUrl;
    /**
     * 文章点赞数
     */
    private Long blogLikes;
    /**
     * 文章查看数
     */
    private Long blogViews;
    /**
     * 是否允许评论（0-不开启 1-开启）
     */
    private String commentStatus;
    /**
     * 状态（0-草稿  1-发布）
     */
    private String status;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;
    /**
     * 更新人
     */
    private String updatedBy;

}
