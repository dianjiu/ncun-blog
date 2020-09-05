package cn.org.dianjiu.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * (TMenu)实体类
 *
 * @author makejava
 * @since 2020-09-05 21:30:58
 */
@Data
public class TMenu {
    /**
     * 主键，自增长
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
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 0  -- 未读  1 -- 已用
     */
    private String status;

}