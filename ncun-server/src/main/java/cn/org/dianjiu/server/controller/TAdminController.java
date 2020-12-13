package cn.org.dianjiu.server.controller;

import cn.org.dianjiu.common.pojo.req.TUserReq;
import cn.org.dianjiu.common.pojo.resp.TUserResp;
import cn.org.dianjiu.common.pojo.vo.RespVO;
import cn.org.dianjiu.common.util.HttpClientUtils;
import cn.org.dianjiu.common.util.ObjectUtils;
import cn.org.dianjiu.server.service.TUserServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * 后管操作控制层
 *
 * @author dianjiu
 * @since 2020-12-13 18:51:50
 */
@Slf4j
@RestController
@Api(value = "admin", tags = {"后管操作"})
@RequestMapping("/admin")
public class TAdminController {

    @Value("${emen.auth.authcookie}")
    private String authCookieUrl;
    @Value("${emen.auth.authlogin}")
    private String authLoginUrl;
    @Value("${emen.auth.authlogout}")
    private String authLogoutUrl;
    @Autowired
    private TUserServiceI tUserService;

    /**
     * 先从浏览器取到cookie，
     * 客户端本地验证cookie，
     * 服务端远程验证cookie。
     */
    @GetMapping("/checkLogin")
    public RespVO<TUserResp> checkLogin (@RequestParam(value = "username",required = true)
                                         @ApiParam(value = "用户名")
                                         @NotNull(message = "用户名不能为空") String userName,
                                         @RequestParam(value = "password",required = true)
                                         @ApiParam(value = "用户名")
                                         @NotNull(message = "用户名不能为空") String password) {
        RespVO<TUserResp> result = new RespVO<>();
        log.info("验证失败,请登录。");
        result.setCode("400");
        result.setMsg("验证失败,请登录。");
        return result;
    }

    /**
     * 先从浏览器取到cookie，
     * 客户端本地验证cookie，
     * 服务端远程验证cookie。
     */
    @GetMapping("/checkCookie")
    public RespVO<TUserResp> checkCookie (HttpServletRequest request) {
        RespVO<TUserResp> result = new RespVO<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                //校验cookieName是否为本站用户
                boolean isLocalUser = false;
                if(ObjectUtils.isNotBlank(cookie.getName())){
                    log.error("cookieName=={}不为空,开始本地验证",cookie.getName());
                    TUserReq tUserReq = new TUserReq();
                    tUserReq.setUsername(cookie.getName());
                    TUserResp tUserResp = tUserService.getByEntity(tUserReq);
                    if(ObjectUtils.checkObjAllFieldsIsNotNull(tUserResp)){
                        isLocalUser = true;
                    }
                }
                /*
                 * TODO 考虑用户初始化时，是否同步给依梦论坛为开关
                 *  用户为本地用户且初始化时选择了同步状态，才远程验证。
                 */
                //是本地用户，则进行远程校验
                if (isLocalUser) {
                    log.info("cookieName=={}不为空，开始远程验证",cookie.getName());
                    Map<String, String> map = new HashMap<>();
                    map.put("cookieName", cookie.getName());
                    map.put("cookieValue", cookie.getValue());
                    String status = HttpClientUtils.doPost(authCookieUrl, map);
                    boolean authStatus  = Boolean.valueOf(status);
                    if (authStatus) {
                        log.info("验证通过,请放行。");
                        result.setCode("200");
                        result.setMsg("验证通过,请放行。");
                        return result;
                    }
                }
                break;
            }
        }
        log.info("验证失败,请登录。");
        result.setCode("400");
        result.setMsg("验证失败,请登录。");
        return result;
    }
}
