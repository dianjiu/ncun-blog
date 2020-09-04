package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                                import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TComment)实体类
 *
 * @author makejava
 * @since 2020-09-04 15:06:14
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