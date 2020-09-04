package cn.org.dianjiu.common.pojo.vo.resp;

import java.util.Date;
import lombok.Data;
                import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 * (TUserRolesResp) Resp
 *
 * @author makejava
 * @since 2020-09-04 15:06:17
 */
@Data 
public class TUserRolesResp implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
        @ApiModelProperty("主键，自增长")
            private Integer id;
        @ApiModelProperty("用户表id")
            private Integer userId;
        @ApiModelProperty("角色表id")
            private Integer roleId;
        @ApiModelProperty("创建时间")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date createTime;
        @ApiModelProperty("更新时间")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date updateTime;
        @ApiModelProperty("0  -- 未读  1 -- 已用")
            private String status;

}