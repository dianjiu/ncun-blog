package cn.org.dianjiu.core.pojo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TBlogTypeResp) Resp
 *
 * @author dianjiu
 * @since 2020-05-23 22:06:16
 */
@Data
public class TBlogTypeResp implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("唯一ID")
    private Integer id;
    @ApiModelProperty("标签名称")
    private String labelName;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    @ApiModelProperty("0  -- 类型  1 -- 分类   2 -- 标签		3 -- 专题")
    private String type;
    @ApiModelProperty("0  -- 未读  1 -- 已用")
    private String status;

}