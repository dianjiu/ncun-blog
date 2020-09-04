package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                        import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TJeeblogPlugin)实体类
 *
 * @author makejava
 * @since 2020-09-04 15:06:15
 */
@Data 
public class TJeeblogPlugin {
    
    private Integer id;
    /**
    * 插件名(url)
    */
    private String pluginName;
    /**
    * 插件描述
    */
    private String pluginDescribe;
    /**
    * 插件预览图
    */
    private String pluginImg;
    /**
    * 状态 1 -- 生效  0  -- 弃用
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