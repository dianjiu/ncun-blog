package cn.org.dianjiu.core.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (TCommonBaseReq) Req
 *
 * @author dianjiu
 * @since 2020-05-23 22:16:15
 */
@Data
public class TCommonBaseReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("参数名称")
    @NotBlank(message = "参数名称不能为空")
    private String paramName;
    @ApiModelProperty("参数key")
    @NotBlank(message = "参数key不能为空")
    private String paramKey;
    @ApiModelProperty("参数value")
    @NotBlank(message = "参数value不能为空")
    private String paramValue;
    @ApiModelProperty("参数描述")
    @NotBlank(message = "参数描述不能为空")
    private String paramDesc;
    @ApiModelProperty("拓展参数1")
    private String extent1;
    @ApiModelProperty("拓展参数2")
    private String extent2;
    @ApiModelProperty("拓展参数3")
    private String extent3;
    @ApiModelProperty("拓展参数4")
    private String extent4;
    @ApiModelProperty("拓展参数5")
    private String extent5;
    @ApiModelProperty("拓展参数6")
    private String extent6;
    @ApiModelProperty("拓展参数7")
    private String extent7;
    @ApiModelProperty("拓展参数8")
    private String extent8;
    @ApiModelProperty("拓展参数9")
    private String extent9;
    @ApiModelProperty("状态 1 -- 生效  0  -- 弃用")
    private String status;

}