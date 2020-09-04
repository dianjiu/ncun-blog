package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                        import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TJeeblogTheme)实体类
 *
 * @author makejava
 * @since 2020-09-04 15:06:16
 */
@Data 
public class TJeeblogTheme {
    
    private Integer id;
    /**
    * 主题名(url)
    */
    private String themeName;
    /**
    * 主题描述
    */
    private String themeDescribe;
    /**
    * 主题预览图
    */
    private String themeImg;
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