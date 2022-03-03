package com.zhz.justademo.biz.config;

import cn.hutool.json.JSONUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author nice
 */
@Aspect
@Component
public class MethodLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(MethodLogAspect.class);

    private static final String LOGGER_START_TEMPLATE = "[%s] start to invoke this method, method args is %s";

    private static final String LOGGER_END_TEMPLATE = "[%s] end to invoke this method, return result is %s";

    private static final String METHOD_ARGS_TEMPLATE = "%s=%s, ";

    @Around(value = "@annotation(methodLogger)")
    public Object around(ProceedingJoinPoint pjp, MethodLogger methodLogger) throws Throwable {
        int argsLen = methodLogger.argsLen();
        // 获取当前执行方法的方法名、参数名、参数值等基础信息
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        // 打印方法调用的基本信息
        logger.info(buildStartLoggerInfo(signature, pjp.getArgs(), argsLen));

        // 执行业务逻辑
        Object res = pjp.proceed();

        // 打印方法调用结果信息
        logger.info(buildEndLoggerInfo(signature, res, argsLen));
        return res;
    }

    private String buildStartLoggerInfo(MethodSignature signature, Object[] args, int argsLen) {
        // 方法名称
        String methodName = signature.getName();
        // 参数名-参数值
        String argsNameValue = buildArgsNameValue(signature.getParameterNames(), args);

        return String.format(LOGGER_START_TEMPLATE, methodName, getLimitStr(argsNameValue, argsLen));
    }

    private String buildEndLoggerInfo(MethodSignature signature, Object res, int argsLen) {
        // 方法名称
        String methodName = signature.getName();
        return String.format(LOGGER_END_TEMPLATE, methodName, getLimitStr(res, argsLen));
    }

    private String buildArgsNameValue(String[] argsNames, Object[] argsValues) {
        String argsNameValue = StringUtils.EMPTY;
        for (int i = 0; i < argsNames.length; i++) {
            String argsName = argsNames[i];
            Object argsValue = argsValues[i];
            argsNameValue = StringUtils.join(argsNameValue, String.format(METHOD_ARGS_TEMPLATE, argsName, argsValue));
        }
        return argsNameValue;
    }

    private String getLimitStr(Object args, int argsLen) {
        return StringUtils.left(JSONUtil.toJsonStr(args), argsLen);
    }

}
