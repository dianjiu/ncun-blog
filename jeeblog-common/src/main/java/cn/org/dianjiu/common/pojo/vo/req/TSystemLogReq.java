package cn.org.dianjiu.common.pojo.vo.req;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * (TSystemLogReq) Req
 *
 * @author makejava
 * @since 2020-09-04 15:06:17
 */
@Data 
public class TSystemLogReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
        @ApiModelProperty("唯一ID")
            private Integer id;
        @ApiModelProperty("流水号")
            private String businessNo;
        @ApiModelProperty("请求路径")
            private String reqUrl;
        @ApiModelProperty("请求描述")
            private String reqDesc;
        @ApiModelProperty("请求报文")
            private Object reqBody;
        @ApiModelProperty("响应报文")
            private Object respBody;
        @ApiModelProperty("请求耗时")
            private String timeCost;
        @ApiModelProperty("请求IP")
            private String reqIp;
        @ApiModelProperty("IP归属")
            private String ipAddr;
        @ApiModelProperty("创建时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date createTime;
        @ApiModelProperty("更新时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date updateTime;

}