package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                        import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TFriendUrl)实体类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
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
    private String friendName;
    /**
    * 友链头像
    */
    private String friendImg;
    /**
    * 友链介绍
    */
    private String friendInfo;
    /**
    * 友链地址
    */
    private String friendUrl;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 创建时间
    */
    private Date updateTime;

}