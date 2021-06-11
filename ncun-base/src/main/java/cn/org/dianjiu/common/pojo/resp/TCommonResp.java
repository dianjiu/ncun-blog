package cn.org.dianjiu.common.pojo.resp;

import java.util.Date;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 字典操作(TCommonResp) Resp
 *
 * @author dianjiu
 * @since 2021-06-11 11:39:06
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
    @ApiModelProperty("状态 1 -- 生效  0  -- 弃用")
    private String status;
    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    @ApiModelProperty("创建人")
    private String createdBy;
    @ApiModelProperty("更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;
    @ApiModelProperty("更新人")
    private String updatedBy;

}
