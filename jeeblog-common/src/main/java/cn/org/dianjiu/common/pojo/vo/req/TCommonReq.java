package cn.org.dianjiu.common.pojo.vo.req;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * (TCommonReq) Req
 *
 * @author makejava
 * @since 2020-09-04 15:06:15
 */
@Data 
public class TCommonReq implements Serializable {
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
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date createTime;
        @ApiModelProperty("更新时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date updateTime;

}