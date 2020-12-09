package cn.org.dianjiu.server.controller;

import cn.org.dianjiu.common.pojo.resp.TUserResp;
import cn.org.dianjiu.common.pojo.vo.RespVO;
import cn.org.dianjiu.common.util.HttpClientUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 博客操作(TBlog)表控制层
 *
 * @author makejava
 * @since 2020-10-06 18:51:50
 */
@Slf4j
@RestController
@Api(value = "admin", tags = {"后管操作"})
@RequestMapping("/admin")
public class TAdminController {
    /**
     * 客户端先验证cookie，
     * 能从浏览器取到cookie，
     * 就去sso系统验证cookie
     */
    @GetMapping("/checkCookie")
    public RespVO<TUserResp> checkCookie (HttpServletRequest request) {
        RespVO<TUserResp> result = new RespVO<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                //TODO 查询该站点所属用户
                //统一登录cookieName为用户名，如果存在就认证
                if ("dianjiu".equals(cookie.getName())) {
                    log.info("cookieName 存在，开始远程验证");
                    Map<String, String> map = new HashMap<>();
                    map.put("cookieName", cookie.getName());
                    map.put("cookieValue", cookie.getValue());
                    String status = HttpClientUtils.doPost("http://sso.com/sso/authCookie", map);
                    boolean authStatus  = Boolean.valueOf(status);
                    if (authStatus) {
                        log.info("验证通过,请放行。");
                        result.setCode("200");
                        result.setMsg("验证通过,请放行。");
                        return result;
                    }
                    break;
                }
            }
        }
        log.info("验证失败,请登录。");
        result.setCode("200");
        result.setMsg("验证失败,请登录。");
        return result;
    }
}
