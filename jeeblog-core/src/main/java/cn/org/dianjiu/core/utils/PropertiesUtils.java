package cn.org.dianjiu.core.utils;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * Created by Dianjiu on 2020/2/14
 * 通过${key}作为name格式调用getPropertiesValue()方法
 * 使用示例：
 * String isNullFalg = PropertiesUtils.getPropertiesValue("${chexian.isnull.flag}");
 * log.info("是否注入配置文件："+isNullFalg);
 */
@Component
public class PropertiesUtils implements EmbeddedValueResolverAware {

    private static StringValueResolver stringValueResolver;

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        stringValueResolver = resolver;
    }

    public static String getPropertiesValue(String name){
        return stringValueResolver.resolveStringValue(name);
    }
}
