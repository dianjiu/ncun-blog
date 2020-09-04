package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                            import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TFriendUrl)实体类
 *
 * @author makejava
 * @since 2020-09-04 15:06:15
 */
@Data 
public class TFriendUrl {
    /**
    * 主键
    */
    private Integer id;
    /**
    * 友链名
    */
    private String linkName;
    /**
    * 友链头像
    */
    private String linkImg;
    /**
    * 友链介绍
    */
    private String linkInfo;
    /**
    * 友链地址
    */
    private String linkUrl;
    /**
    * 状态 1 -- 生效  0  -- 弃用
    */
    private String status;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 创建时间
    */
    private Date updateTime;

}