package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                                                                import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TCommonBase)实体类
 *
 * @author dianjiu
 * @since 2020-06-09 01:11:56
 */
@Data 
public class TCommonBase {
    /**
    * 唯一ID
    */
    private Integer id;
    /**
    * 参数名称
    */
    private String paramName;
    /**
    * 参数key
    */
    private String paramKey;
    /**
    * 参数value
    */
    private String paramValue;
    /**
    * 参数描述
    */
    private String paramDesc;
    /**
    * 拓展参数1
    */
    private String extent1;
    /**
    * 拓展参数2
    */
    private String extent2;
    /**
    * 拓展参数3
    */
    private String extent3;
    /**
    * 拓展参数4
    */
    private String extent4;
    /**
    * 拓展参数5
    */
    private String extent5;
    /**
    * 拓展参数6
    */
    private String extent6;
    /**
    * 拓展参数7
    */
    private String extent7;
    /**
    * 拓展参数8
    */
    private String extent8;
    /**
    * 拓展参数9
    */
    private String extent9;
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