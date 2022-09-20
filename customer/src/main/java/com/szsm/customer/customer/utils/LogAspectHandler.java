package com.szsm.customer.customer.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspectHandler {

    @Pointcut("execution(public * com.szsm.customer.customer.controller..*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        return result;
    }

    @AfterThrowing(value = "pointCut()", throwing = "throwable")
    public Object afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        return throwable;
    }

    public static void main(String[] args) {
        System.out.println(Result.success("Hello!"));
    }
}
