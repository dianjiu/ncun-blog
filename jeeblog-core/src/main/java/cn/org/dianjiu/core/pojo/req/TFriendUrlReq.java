package cn.org.dianjiu.core.pojo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (TFriendUrlReq) Req
 *
 * @author dianjiu
 * @since 2020-05-23 22:16:07
 */
@Data
public class TFriendUrlReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("友链名")
    @NotBlank(message = "友链名不能为空")
    private String friendName;
    @ApiModelProperty("友链头像")
    private String friendImg;
    @ApiModelProperty("友链介绍")
    private String friendInfo;
    @ApiModelProperty("友链地址")
    @NotBlank(message = "友链地址不能为空")
    private String friendUrl;

}