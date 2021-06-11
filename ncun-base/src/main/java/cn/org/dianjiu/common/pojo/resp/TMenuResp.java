package cn.org.dianjiu.common.pojo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单操作(TMenuResp) Resp
 *
 * @author dianjiu
 * @since 2021-06-11 11:38:39
 */
@Data
public class TMenuResp implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("唯一ID")
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
    @ApiModelProperty("0  -- 弃用  1 -- 启用")
    private String status;
    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    @ApiModelProperty("创建人")
    private String createdBy;
    @ApiModelProperty("更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;
    @ApiModelProperty("更新人")
    private String updatedBy;

}
