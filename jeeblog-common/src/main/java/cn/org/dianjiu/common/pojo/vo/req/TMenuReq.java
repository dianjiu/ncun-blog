package cn.org.dianjiu.common.pojo.vo.req;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * (TMenuReq) Req
 *
 * @author makejava
 * @since 2020-09-04 15:06:16
 */
@Data 
public class TMenuReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
        @ApiModelProperty("主键，自增长")
            private Integer id;
        @ApiModelProperty("菜单url（Controller 请求路径）")
            private String menuUrl;
        @ApiModelProperty("菜单名称")
            private String menuName;
        @ApiModelProperty("菜单图标")
            private String menuIcon;
        @ApiModelProperty("排序")
            private Integer menuSort;
        @ApiModelProperty("打开方式")
            private String menuTarget;
        @ApiModelProperty("创建时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date createTime;
        @ApiModelProperty("更新时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date updateTime;
        @ApiModelProperty("0  -- 未读  1 -- 已用")
            private String status;

}