package com.lps.boot.reflect;

import com.lps.boot.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Method;

@Slf4j
public class ReflectHandler {
    public ReflectHandler() {
    }

    public static Object invoke(ReflectBean tBean, Object[] oArgs, ConfigurableApplicationContext context) {
        String className = tBean.getClassName();
        String methodName = tBean.getMethodName();
        return invoke(className, methodName, oArgs, context);
    }

    public static Object invoke(String className, String methodName, Object[] oArgs, ConfigurableApplicationContext context) {
        Object result = null;
        Class serviceClass = null;
        Class[] oMethodArgType = null;
        Method method = null;
        Object service = null;

        try {
            if (className != null && methodName != null) {
                oMethodArgType = new Class[oArgs.length];

                for (int i = 0; i < oArgs.length; ++i) {
                    oMethodArgType[i] = oArgs[i].getClass();
                }

                service = context.getBean(StringUtil.toLowerCaseFirstOne(className));
                method = service.getClass().getMethod(methodName, oMethodArgType);
                result = method.invoke(service, oArgs);
            } else {
                log.error("服务平台|类名或方法名为空");
            }
        } catch (IllegalAccessException var10) {
            log.error("无法访问指定类、字段、方法", var10);
        } catch (SecurityException var11) {
            log.error("安全管理器抛出的异常", var11);
        } catch (NoSuchMethodException var12) {
            log.error("无法找到某一特定方法", var12);
        } catch (IllegalArgumentException var13) {
            log.error("向调用方法中传递了不合法或不正确的参数", var13);
        } catch (Exception var14) {
            log.error("出现异常", var14);
        }

        return result;
    }
}
