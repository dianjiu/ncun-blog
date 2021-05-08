package cn.org.dianjiu.server.entity;

import java.util.Date;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 文件操作(TFile)实体类
 *
 * @author dianjiu
 * @since 2021-05-08 17:51:13
 */
@Data
public class TFile {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 预览地址
     */
    private String filePreviewPath;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件大小
     */
    private String fileSize;
    /**
     * 后缀
     */
    private String fileSuffix;
    /**
     * 状态 1 -- 生效  0  -- 弃用
     */
    private String status;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedTime;
    /**
     * 更新人
     */
    private String updatedBy;

}
