package cn.org.dianjiu.common.pojo.vo.req;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * (TJeeblogThemeReq) Req
 *
 * @author makejava
 * @since 2020-09-04 15:06:16
 */
@Data 
public class TJeeblogThemeReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
            private Integer id;
        @ApiModelProperty("主题名(url)")
            private String themeName;
        @ApiModelProperty("主题描述")
            private String themeDescribe;
        @ApiModelProperty("主题预览图")
            private String themeImg;
        @ApiModelProperty("状态 1 -- 生效  0  -- 弃用")
            private String status;
        @ApiModelProperty("创建时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date createTime;
        @ApiModelProperty("更新时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date updateTime;

}