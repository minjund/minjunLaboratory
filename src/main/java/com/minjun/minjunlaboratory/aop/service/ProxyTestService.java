package com.minjun.minjunlaboratory.aop.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProxyTestService {
    
    @Autowired
    private TestService testService;

    @Transactional
    public String testNormalCall() {
        System.out.println("일반적인 호출 (Spring 컨테이너를 통한 프록시 사용)");
        return testService.doSomething();
    }
    
    public String testDirectProxyCall() {
        System.out.println("프록시 객체를 직접 전달한 호출");
        return callWithDirectProxy(testService);
    }
    
    public String callWithDirectProxy(TestService service) {
        System.out.println(" 프록시 객체가 직접 전달됨 - AOP가 적용될까요?");
        return service.doAnotherThing();
    }
    
    public String testSelfInvocation() {
        System.out.println("자기 자신 호출 (Self-Invocation)");
        return this.internalMethod();
    }
    
    public String internalMethod() {
        System.out.println(" 내부 메서드 호출 - AOP가 적용될까요?");
        return "내부 메서드 실행 완료";
    }
}