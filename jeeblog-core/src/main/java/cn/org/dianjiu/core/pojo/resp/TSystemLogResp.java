package cn.org.dianjiu.core.pojo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TSystemLogResp) Resp
 *
 * @author dianjiu
 * @since 2020-05-23 22:15:59
 */
@Data
public class TSystemLogResp implements Serializable {
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
    private String reqBody;
    @ApiModelProperty("响应报文")
    private String respBody;
    @ApiModelProperty("请求耗时")
    private String timeCost;
    @ApiModelProperty("请求IP")
    private String reqIp;
    @ApiModelProperty("IP归属")
    private String ipAddr;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}