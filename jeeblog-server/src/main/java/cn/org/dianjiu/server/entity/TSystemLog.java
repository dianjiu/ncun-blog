package cn.org.dianjiu.server.entity;

import java.util.Date;
import lombok.Data;
                                        import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * (TSystemLog)实体类
 *
 * @author makejava
 * @since 2020-09-04 15:06:17
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
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;

}