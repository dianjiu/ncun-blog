package cn.org.dianjiu.core.pojo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TFriendUrlResp) Resp
 *
 * @author dianjiu
 * @since 2020-05-23 22:16:07
 */
@Data
public class TFriendUrlResp implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("友链名")
    private String friendName;
    @ApiModelProperty("友链头像")
    private String friendImg;
    @ApiModelProperty("友链介绍")
    private String friendInfo;
    @ApiModelProperty("友链地址")
    private String friendUrl;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}