package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                                                                                                                                    import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TCommon)实体类
 *
 * @author makejava
 * @since 2020-09-04 15:06:14
 */
@Data 
public class TCommon {
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
    * key1
    */
    private String key1;
    /**
    * value1
    */
    private String value1;
    /**
    * key2
    */
    private String key2;
    /**
    * value2
    */
    private String value2;
    /**
    * key3
    */
    private String key3;
    /**
    * value3
    */
    private String value3;
    /**
    * key4
    */
    private String key4;
    /**
    * value4
    */
    private String value4;
    /**
    * key5
    */
    private String key5;
    /**
    * value5
    */
    private String value5;
    /**
    * key6
    */
    private String key6;
    /**
    * value6
    */
    private String value6;
    /**
    * key7
    */
    private String key7;
    /**
    * value7
    */
    private String value7;
    /**
    * key8
    */
    private String key8;
    /**
    * value8
    */
    private String value8;
    /**
    * key9
    */
    private String key9;
    /**
    * value9
    */
    private String value9;
    /**
    * key10
    */
    private String key10;
    /**
    * value10
    */
    private String value10;
    /**
    * key11
    */
    private String key11;
    /**
    * value11
    */
    private String value11;
    /**
    * key12
    */
    private String key12;
    /**
    * value12
    */
    private String value12;
    /**
    * key13
    */
    private String key13;
    /**
    * value13
    */
    private String value13;
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