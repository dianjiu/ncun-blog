package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                                import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TCommentBase)实体类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Data 
public class TCommentBase {
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
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 状态（0-待审核  1-已审核）
    */
    private String status;

}