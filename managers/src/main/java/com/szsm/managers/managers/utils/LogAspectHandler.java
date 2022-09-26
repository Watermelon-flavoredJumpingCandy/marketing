package com.szsm.managers.managers.utils;

import com.alibaba.fastjson.JSON;
import com.szsm.common.entity.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspectHandler {

    @Pointcut("execution(public * com.szsm.managers.managers.controller..*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            log.info("交易 [start] {}#{}", proceedingJoinPoint.getTarget().getClass().getSimpleName(), proceedingJoinPoint.getSignature().getName());
            log.info("--- LogAspectHandler - doAround - request : " + JSON.toJSONString(proceedingJoinPoint.getArgs()));
            Object result = proceedingJoinPoint.proceed();
            log.info("--- LogAspectHandler - doAround - response : " + JSON.toJSONString(result));
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            log.info("交易 [end] {}ms  {}#{}", end - start, proceedingJoinPoint.getTarget().getClass().getSimpleName(), proceedingJoinPoint.getSignature().getName());
        }
    }

    @AfterThrowing(value = "pointCut()", throwing = "throwable")
    public Object afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        return throwable;
    }

    public static void main(String[] args) {
        System.out.println(ResultData.success("Hello!"));
    }
}
