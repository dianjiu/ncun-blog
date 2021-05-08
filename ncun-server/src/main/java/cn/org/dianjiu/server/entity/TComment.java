package cn.org.dianjiu.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 评论操作(TComment)实体类
 *
 * @author dianjiu
 * @since 2021-05-08 17:51:09
 */
@Data
public class TComment {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 博客id
     */
    private Integer blogId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 站点
     */
    private String site;
    /**
     * 内容
     */
    private String content;
    /**
     * 父ID
     */
    private Integer parentId;
    /**
     * 状态（0-待审核  1-已审核）
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
