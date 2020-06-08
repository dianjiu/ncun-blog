package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                                                    import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TBlogBase)实体类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:53
 */
@Data 
public class TBlogBase {
    /**
    * 唯一ID
    */
    private Integer id;
    /**
    * 标题
    */
    private String articleTitle;
    /**
    * 文章正文
    */
    private Object articleText;
    /**
    * 文章摘要
    */
    private String articleSummary;
    /**
    * 文章类型(原创，转载)
    */
    private String articleType;
    /**
    * 博客分类
    */
    private String articleCategories;
    /**
    * 文章标签
    */
    private String articleLabel;
    /**
    * 文章专题
    */
    private String articleSpecial;
    /**
    * 文章热度（10表示置顶）
    */
    private Integer articleGrade;
    /**
    * 文章作者
    */
    private String articleAuthor;
    /**
    * 缩略图像
    */
    private String articleImgs;
    /**
    * 状态（0-草稿  1-发布）
    */
    private String status;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;

}