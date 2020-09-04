package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                                    import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TFile)实体类
 *
 * @author makejava
 * @since 2020-09-04 15:06:15
 */
@Data 
public class TFile {
    
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
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;

}