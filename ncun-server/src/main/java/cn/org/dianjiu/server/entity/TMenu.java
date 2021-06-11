package cn.org.dianjiu.server.entity;

import java.util.Date;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 菜单操作(TMenu)实体类
 *
 * @author dianjiu
 * @since 2021-06-11 11:38:37
 */
@Data
public class TMenu {
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 菜单url（Controller 请求路径）
     */
    private String menuUrl;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 排序
     */
    private Integer menuSort;
    /**
     * 打开方式
     */
    private String menuTarget;
    /**
     * 0  -- 弃用  1 -- 启用
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
