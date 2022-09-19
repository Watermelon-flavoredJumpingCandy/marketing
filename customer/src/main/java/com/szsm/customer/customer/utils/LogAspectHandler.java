package com.szsm.customer.customer.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspectHandler {

    @Pointcut("execution(* com.szsm.customer.customer..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {

    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {

    }

    @AfterReturning(value = "pointCut()", returning = "obj")
    public Object doAfterReturning(JoinPoint joinPoint, Object obj) {
        return Result.success(obj);
    }

    @AfterThrowing(value = "pointCut()", throwing = "throwable")
    public Object afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        return throwable;
    }
}
