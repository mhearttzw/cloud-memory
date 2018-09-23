package com.cloud.memory.common.aop;

import com.cloud.memory.common.annotation.MeteredRemoteCall;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MetricAspect {



    //@Around(value = "execution(* com.cloud.memory.controller..*(..))||execution(* com.cloud.memory.service..*(..))")
    //@Around(value = "execution(* com.cloud.memory.controller..*(..))")
    @Around(value = "@annotation(annotation)", argNames = "joinPoint,annotation")
    public Object meterRemoteCall(ProceedingJoinPoint joinPoint, MeteredRemoteCall annotation)
        throws Throwable
    {
        System.out.println(joinPoint);
        System.out.println("sopdfsdfasfda");
        return joinPoint.proceed();
    }
}