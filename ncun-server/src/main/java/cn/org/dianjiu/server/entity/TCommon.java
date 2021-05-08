package cn.org.dianjiu.server.entity;

import java.util.Date;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 字典操作(TCommon)实体类
 *
 * @author dianjiu
 * @since 2021-05-08 17:51:11
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
     * 状态 1 -- 生效  0  -- 弃用
     */
    private String status;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;
    /**
     * 更新人
     */
    private String updatedBy;

}
