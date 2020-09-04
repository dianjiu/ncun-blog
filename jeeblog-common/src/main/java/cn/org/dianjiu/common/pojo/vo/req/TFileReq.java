package cn.org.dianjiu.common.pojo.vo.req;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
/**
 * (TFileReq) Req
 *
 * @author makejava
 * @since 2020-09-04 15:06:15
 */
@Data 
public class TFileReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
            private Integer id;
        @ApiModelProperty("文件名称")
            private String fileName;
        @ApiModelProperty("文件路径")
            private String filePath;
        @ApiModelProperty("预览地址")
            private String filePreviewPath;
        @ApiModelProperty("文件类型")
            private String fileType;
        @ApiModelProperty("文件大小")
            private String fileSize;
        @ApiModelProperty("后缀")
            private String fileSuffix;
        @ApiModelProperty("状态 1 -- 生效  0  -- 弃用")
            private String status;
        @ApiModelProperty("创建时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date createTime;
        @ApiModelProperty("更新时间")
            @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        private Date updateTime;

}