package cn.org.dianjiu.common.pojo.dto;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公共常量
 * 
 * @author : 宋浩志
 * @createDate : 2018年9月20日
 */
public class Const {
	/**
	 * user_session
	 */
	public static final String USER_SESSION_KEY = "user_session";
	/**
	 * 最大页码
	 */
	public static final int MAX_PAGE = 100;
	/**
	 * 所有设置选项
	 */
	public static Map<String, String> OPTIONS = new HashMap<String, String>();
	/**
	 * 所有菜单
	 */
	//public static List<TMenuResp> MENUS = new ArrayList<TMenuResp>();
	/**
	 * 主题
	 */
	public static String THEME_NAME;

	/**
	 * 插件
	 */
	public static List<String> PLIGINS;
	
	/**
	 * 同一IP十分钟以内重复访问同一篇文章只算一次
	 */
	public static final Integer IP_REPEAT_TIME=600;
	
	/**
     * 点击次数超过多少更新到数据库
     */
    public static final int CLICK_EXCEED = 10; 
}
