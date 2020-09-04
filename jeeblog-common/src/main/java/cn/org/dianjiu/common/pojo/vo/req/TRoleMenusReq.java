package cn.org.dianjiu.common.pojo.vo.req;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * (TRoleMenusReq) Req
 *
 * @author makejava
 * @since 2020-09-04 15:06:17
 */
@Data 
public class TRoleMenusReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
        @ApiModelProperty("主键，自增长")
            private Integer id;
        @ApiModelProperty("菜单表id")
            private Integer menuId;
        @ApiModelProperty("角色表id")
            private Integer roleId;
        @ApiModelProperty("创建时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date createTime;
        @ApiModelProperty("更新时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date updateTime;
        @ApiModelProperty("0  -- 未读  1 -- 已用")
            private String status;

}