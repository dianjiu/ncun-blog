package cn.org.dianjiu.server.entity;

import java.util.Date;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 日志操作(TSystemLog)实体类
 *
 * @author dianjiu
 * @since 2021-05-08 17:51:22
 */
@Data
public class TSystemLog {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 流水号
     */
    private String businessNo;
    /**
     * 请求路径
     */
    private String reqUrl;
    /**
     * 请求描述
     */
    private String reqDesc;
    /**
     * 请求报文
     */
    private Object reqBody;
    /**
     * 响应报文
     */
    private Object respBody;
    /**
     * 请求耗时
     */
    private String timeCost;
    /**
     * 请求IP
     */
    private String reqIp;
    /**
     * IP归属
     */
    private String ipAddr;
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
