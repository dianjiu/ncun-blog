package cn.org.dianjiu.common.pojo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件操作(TFileReq) Req
 *
 * @author dianjiu
 * @since 2021-06-11 11:39:08
 */
@Data
public class TFileReq implements Serializable {
    private static final long serialVersionUID = 9155949248117098529L;
    @ApiModelProperty("唯一ID")
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
