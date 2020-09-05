package cn.org.dianjiu.common.pojo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (TCommonResp) Resp
 *
 * @author makejava
 * @since 2020-09-05 21:30:45
 */
@Data
public class TCommonResp implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("唯一ID")
    private Integer id;
    @ApiModelProperty("参数名称")
    private String paramName;
    @ApiModelProperty("参数key")
    private String paramKey;
    @ApiModelProperty("参数value")
    private String paramValue;
    @ApiModelProperty("参数描述")
    private String paramDesc;
    @ApiModelProperty("key1")
    private String key1;
    @ApiModelProperty("value1")
    private String value1;
    @ApiModelProperty("key2")
    private String key2;
    @ApiModelProperty("value2")
    private String value2;
    @ApiModelProperty("key3")
    private String key3;
    @ApiModelProperty("value3")
    private String value3;
    @ApiModelProperty("key4")
    private String key4;
    @ApiModelProperty("value4")
    private String value4;
    @ApiModelProperty("key5")
    private String key5;
    @ApiModelProperty("value5")
    private String value5;
    @ApiModelProperty("key6")
    private String key6;
    @ApiModelProperty("value6")
    private String value6;
    @ApiModelProperty("key7")
    private String key7;
    @ApiModelProperty("value7")
    private String value7;
    @ApiModelProperty("key8")
    private String key8;
    @ApiModelProperty("value8")
    private String value8;
    @ApiModelProperty("key9")
    private String key9;
    @ApiModelProperty("value9")
    private String value9;
    @ApiModelProperty("key10")
    private String key10;
    @ApiModelProperty("value10")
    private String value10;
    @ApiModelProperty("key11")
    private String key11;
    @ApiModelProperty("value11")
    private String value11;
    @ApiModelProperty("key12")
    private String key12;
    @ApiModelProperty("value12")
    private String value12;
    @ApiModelProperty("key13")
    private String key13;
    @ApiModelProperty("value13")
    private String value13;
    @ApiModelProperty("状态 1 -- 生效  0  -- 弃用")
    private String status;
    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}