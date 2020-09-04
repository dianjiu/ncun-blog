package cn.org.dianjiu.common.pojo.vo.resp;

import java.util.Date;
import lombok.Data;
                                    import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 * (TFileResp) Resp
 *
 * @author makejava
 * @since 2020-09-04 15:06:15
 */
@Data 
public class TFileResp implements Serializable {
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
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date createTime;
        @ApiModelProperty("更新时间")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date updateTime;

}