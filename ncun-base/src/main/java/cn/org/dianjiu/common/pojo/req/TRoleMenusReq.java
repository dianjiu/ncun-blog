package cn.org.dianjiu.common.pojo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (TRoleMenusReq) Req
 *
 * @author makejava
 * @since 2020-09-05 21:31:15
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    @ApiModelProperty("0  -- 未读  1 -- 已用")
    private String status;

}