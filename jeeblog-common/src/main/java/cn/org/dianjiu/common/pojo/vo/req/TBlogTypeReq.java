package cn.org.dianjiu.common.pojo.vo.req;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * (TBlogTypeReq) Req
 *
 * @author makejava
 * @since 2020-09-04 15:06:14
 */
@Data 
public class TBlogTypeReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
        @ApiModelProperty("唯一ID")
            private Integer id;
        @ApiModelProperty("标签名称")
            private String labelName;
        @ApiModelProperty("分类路径")
            private String typeUrl;
        @ApiModelProperty("描述")
            private String typeDescribe;
        @ApiModelProperty("0  -- 类型  1 -- 分类   2 -- 标签   3 -- 专题")
            private String type;
        @ApiModelProperty("0  -- 未读  1 -- 已用")
            private String status;
        @ApiModelProperty("创建时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date createTime;
        @ApiModelProperty("更新时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date updateTime;

}