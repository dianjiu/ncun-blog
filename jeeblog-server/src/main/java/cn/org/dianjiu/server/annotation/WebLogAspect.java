package cn.org.dianjiu.server.annotation;


import cn.org.dianjiu.core.pojo.req.TSystemLogReq;
import cn.org.dianjiu.core.pojo.resp.TSystemLogResp;
import cn.org.dianjiu.core.pojo.vo.RespVO;
import cn.org.dianjiu.core.utils.IPUtils;
import cn.org.dianjiu.server.service.TSystemLogServiceI;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Aspect
@Component
@Order(100)
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    private ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    @Autowired
    private TSystemLogServiceI tSystemLogService;

    /**
     * 横切点
     */
    //@Pointcut("execution(public * cn.jeeblog.api.controller..*.*(..))")
    @Pointcut("@annotation(cn.org.dianjiu.server.annotation.WebLog)")
    public void webLog() {
    }


    /**
     * 接收请求，并记录数据
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        Method method = getMethod(joinPoint);
        WebLog webLog = method.getAnnotation(WebLog.class);
        // 接收到请求
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        // 记录请求内容，threadInfo存储所有内容
        Map<String, Object> threadInfo = new HashMap<>();
        logger.info("URL : " + request.getRequestURL());
        threadInfo.put("url", request.getRequestURL());
        logger.info("URI : " + request.getRequestURI());
        threadInfo.put("uri", request.getRequestURI());
        logger.info("HTTP_METHOD : " + request.getMethod());
        threadInfo.put("httpMethod", request.getMethod());
        String ip = IPUtils.getIpAddress(request);
        String ipInfo = IPUtils.getIPInfo(ip);
        threadInfo.put("ip", ip);
        logger.info("ip : " + ip);
        threadInfo.put("ipAddr", ipInfo);
        logger.info("ipAddr : " + ipInfo);
        // TODO 通过IP工具类过去IP和IP归属地
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        threadInfo.put("classMethod",
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        threadInfo.put("args", Arrays.toString(joinPoint.getArgs()));
        logger.info("USER_AGENT"+request.getHeader("User-Agent"));
        threadInfo.put("userAgent", request.getHeader("User-Agent"));
        logger.info("执行方法说明：" + webLog.desc());
        threadInfo.put("methodDesc", webLog.desc());
        threadLocal.set(threadInfo);
    }

    /**
     * 定制一个环绕通知
     * @param joinPoint
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = joinPoint.proceed();
        Map<String, Object> threadInfo = threadLocal.get();
        Long timeCost = System.currentTimeMillis() - startTime;
        threadInfo.put("timeCost", timeCost);
        threadLocal.set(threadInfo);
        logger.info("耗时：" + timeCost);
        threadLocal.set(threadInfo);
        return ob;
    }

    /**
     * 执行成功后处理
     * @param joinPoint
     * @param resp
     * @throws Throwable
     */
    @AfterReturning(value = "webLog()", returning = "resp")
    public void doAfterReturning(JoinPoint joinPoint, Object resp) throws Exception {
        Method method = getMethod(joinPoint);
        WebLog webLog = method.getAnnotation(WebLog.class);
        Map<String, Object> threadInfo = threadLocal.get();
        threadInfo.put("result", resp);
        if (webLog.intoDb()) {
            //插入数据库操作
            insertSystemLog(threadInfo);
        }
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + resp.toString());
    }

    /**
     * 存储操作日志
     * @param threadInfo
     */
    private void insertSystemLog(Map<String, Object> threadInfo) {
        TSystemLogReq tSystemLogReq = new TSystemLogReq();
        tSystemLogReq.setBusinessNo(UUID.randomUUID().toString());
        tSystemLogReq.setReqUrl(String.valueOf(threadInfo.get("uri")));
        tSystemLogReq.setReqBody(String.valueOf(threadInfo.get("args")));
        tSystemLogReq.setReqDesc(String.valueOf(threadInfo.get("methodDesc")));
        tSystemLogReq.setRespBody(String.valueOf(threadInfo.get("resp")));
        tSystemLogReq.setReqIp(String.valueOf(threadInfo.get("ip")));
        tSystemLogReq.setIpAddr(String.valueOf(threadInfo.get("ipAddr")));
        tSystemLogReq.setTimeCost(String.valueOf(threadInfo.get("timeCost")));
        logger.info("调用日志接口的入参为："+tSystemLogReq.toString());
        int insert = tSystemLogService.insert(tSystemLogReq);
        logger.info("调用日志接口的出参为："+insert);
        /*logger.info("通过fegin调用日志接口的入参为："+tSystemLogReq.toString());
        tSystemLogService tSystemLogService = SpringUtils.getBean(tSystemLogService.class);
        logger.info("是否注入了feign客户端："+tSystemLogService);
        RespVO<TSystemLogResp> respVO = tSystemLogService.insert(tSystemLogReq);
        logger.info("通过fegin调用日志接口的出参为："+respVO.toString());*/

    }

    private Method getMethod(JoinPoint joinPoint) throws Exception {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        return method;
    }

    /**
     * 异常处理
     * @param throwable
     */
    @AfterThrowing(value = "webLog()", throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();

        ServletRequestAttributes sra = (ServletRequestAttributes) ra;

        HttpServletRequest request = sra.getRequest();
        // 异常信息
        logger.error("{}接口调用异常，异常信息{}", request.getRequestURI(), throwable);
    }

}


