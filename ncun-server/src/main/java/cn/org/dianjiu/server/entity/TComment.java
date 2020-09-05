package cn.org.dianjiu.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * (TComment)实体类
 *
 * @author makejava
 * @since 2020-09-05 21:30:32
 */
@Data
public class TComment {
    /**
     * 评论id
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
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 状态（0-待审核  1-已审核）
     */
    private String status;

}