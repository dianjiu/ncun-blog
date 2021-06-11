package cn.org.dianjiu.common.pojo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志操作(TSystemLogReq) Req
 *
 * @author dianjiu
 * @since 2021-06-11 11:38:45
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
