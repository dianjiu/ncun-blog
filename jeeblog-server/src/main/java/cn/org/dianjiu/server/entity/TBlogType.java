package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
            import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TBlogType)实体类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Data 
public class TBlogType {
    /**
    * 唯一ID
    */
    private Integer id;
    /**
    * 标签名称
    */
    private String labelName;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 0  -- 类型  1 -- 分类   2 -- 标签   3 -- 专题
    */
    private String type;
    /**
    * 0  -- 未读  1 -- 已用
    */
    private String status;

}