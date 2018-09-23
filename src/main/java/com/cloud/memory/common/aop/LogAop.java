package com.cloud.memory.common.aop;

import com.cloud.memory.common.annotation.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class LogAop {

    private Logger logger = LoggerFactory.getLogger(LogAop.class);
    private static final String STRING_START = "\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n";


    // 设置切点表达式，匹配com.wangxin.springboot包及其子包下面所有类的public方法
    // 配置多个切点
    @Pointcut("execution(* com.cloud.memory.controller..*(..))||execution(* com.cloud.memory.service..*(..))")
    private void pointcut(){

    }

//    @Around("pointcut()")
    @Around("@annotation(com.cloud.memory.common.annotation.Log)" + " || @within(com.cloud.memory.common.annotation.Log))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();

        StringBuffer classAndMethod = new StringBuffer();

        Log classAnnotation = targetClass.getAnnotation(Log.class);
        Log methodAnnotation = method.getAnnotation(Log.class);

        if (classAnnotation != null) {
            if (classAnnotation.ignore()) {
                return joinPoint.proceed();
            }
            classAndMethod.append(classAnnotation.logStr()).append("-");
        }

        if (methodAnnotation != null) {
            if (methodAnnotation.ignore()) {
                return joinPoint.proceed();
            }
            classAndMethod.append(methodAnnotation.logStr());
        }


        // TODO 重点SerializerFeature.IgnoreErrorGetter参数的使用

        logger.info(STRING_START + " 开始调用--> :{}", "hello log aop");

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long timeConsuming = System.currentTimeMillis() - start;

        System.out.println("时间消耗：" + timeConsuming);

        return result;
    }



    @AfterReturning(returning = "object", pointcut = "pointcut()")
    public void afterReturning(Object object) {

    }


}
