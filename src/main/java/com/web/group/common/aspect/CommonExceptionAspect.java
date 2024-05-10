package com.web.group.common.aspect;

import com.alibaba.fastjson.JSONObject;
import com.web.group.common.enums.FailEnums;
import com.web.group.common.exception.QyException;
import com.web.group.common.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class CommonExceptionAspect {
    @Pointcut("execution(public * com.web.group.controller..*.*(..))")
    public void apiLog() {
    }


    @Around(value = "apiLog()")
    public Object handlerException(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            log.info("--------------exception log------------");
            log.error(throwable.getMessage());
            if (throwable instanceof QyException) {
                return Response.fail(FailEnums.BIZ_ERROR.getCode(),throwable.getMessage());
            } else if (throwable instanceof ConstraintViolationException) {
                ConstraintViolationException exception = (ConstraintViolationException) throwable;
                Map<String, Object> msg = new HashMap<>();
                exception.getConstraintViolations().forEach(error -> {
                    String message = error.getMessage();
                    String path = error.getPropertyPath().toString();
                    msg.put(path, message);
                });
                return Response.fail(FailEnums.BIZ_ERROR.getCode(), JSONObject.toJSONString(msg));
            } else if (throwable instanceof RuntimeException) {
                throw new RuntimeException(throwable);
            } else {
                return Response.fail(FailEnums.BIZ_ERROR.getCode(),"系统繁忙，请稍后重试");
            }
        }
    }
}
