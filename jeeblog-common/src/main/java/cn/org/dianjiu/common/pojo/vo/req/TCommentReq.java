package cn.org.dianjiu.common.pojo.vo.req;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * (TCommentReq) Req
 *
 * @author makejava
 * @since 2020-09-04 15:06:14
 */
@Data 
public class TCommentReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
        @ApiModelProperty("评论id")
            private Integer id;
        @ApiModelProperty("博客id")
            private Integer blogId;
        @ApiModelProperty("姓名")
            private String name;
        @ApiModelProperty("邮箱")
            private String mail;
        @ApiModelProperty("站点")
            private String site;
        @ApiModelProperty("内容")
            private String content;
        @ApiModelProperty("父ID")
            private Integer parentId;
        @ApiModelProperty("创建时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date createTime;
        @ApiModelProperty("更新时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date updateTime;
        @ApiModelProperty("状态（0-待审核  1-已审核）")
            private String status;

}