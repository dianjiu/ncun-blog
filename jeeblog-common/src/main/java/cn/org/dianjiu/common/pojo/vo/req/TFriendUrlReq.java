package cn.org.dianjiu.common.pojo.vo.req;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * (TFriendUrlReq) Req
 *
 * @author makejava
 * @since 2020-09-04 15:06:15
 */
@Data 
public class TFriendUrlReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
        @ApiModelProperty("主键")
            private Integer id;
        @ApiModelProperty("友链名")
            private String linkName;
        @ApiModelProperty("友链头像")
            private String linkImg;
        @ApiModelProperty("友链介绍")
            private String linkInfo;
        @ApiModelProperty("友链地址")
            private String linkUrl;
        @ApiModelProperty("状态 1 -- 生效  0  -- 弃用")
            private String status;
        @ApiModelProperty("创建时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date createTime;
        @ApiModelProperty("创建时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date updateTime;

}