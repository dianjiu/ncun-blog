package cn.org.dianjiu.server.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WebLog {
    String desc();//所调用接口的描述信息
    boolean intoDb() default false;//标识该条操作日志是否需要持久化存储
}


