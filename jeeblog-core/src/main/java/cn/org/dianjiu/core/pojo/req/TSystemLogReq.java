package cn.org.dianjiu.core.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (TSystemLogReq) Req
 *
 * @author dianjiu
 * @since 2020-05-23 22:15:59
 */
@Data
public class TSystemLogReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("流水号")
    @NotBlank(message = "流水号不能为空")
    private String businessNo;
    @ApiModelProperty("请求路径")
    @NotBlank(message = "请求路径不能为空")
    private String reqUrl;
    @ApiModelProperty("请求描述")
    @NotBlank(message = "请求描述不能为空")
    private String reqDesc;
    @ApiModelProperty("请求报文")
    @NotBlank(message = "请求报文不能为空")
    private String reqBody;
    @ApiModelProperty("响应报文")
    @NotBlank(message = "响应报文不能为空")
    private String respBody;
    @ApiModelProperty("请求耗时")
    @NotBlank(message = "请求耗时不能为空")
    private String timeCost;
    @ApiModelProperty("请求IP")
    @NotBlank(message = "请求IP不能为空")
    private String reqIp;
    @ApiModelProperty("IP归属")
    @NotBlank(message = "IP归属不能为空")
    private String ipAddr;

}