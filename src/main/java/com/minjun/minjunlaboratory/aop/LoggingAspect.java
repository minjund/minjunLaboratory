package com.minjun.minjunlaboratory.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
    @Before("execution(* com.minjun.minjunlaboratory.aop..*.*(..))")
    public void logMethodCall() {
        System.out.println("🔍 AOP 로그: 메서드 호출이 감지되었습니다!");
    }
}