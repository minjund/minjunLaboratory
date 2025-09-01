package com.minjun.minjunlaboratory.aop.controller;

import com.minjun.minjunlaboratory.aop.service.ProxyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop-test")
public class AOPTestController {
    
    @Autowired
    private ProxyTestService proxyTestService;
    
    @GetMapping("/normal")
    public String testNormalCall() {
        System.out.println("\n=== 테스트 1: 일반적인 AOP 호출 ===");
        return proxyTestService.testNormalCall();
    }
    
    @GetMapping("/direct-proxy")
    public String testDirectProxyCall() {
        System.out.println("\n=== 테스트 2: 프록시 객체 직접 전달 ===");
        return proxyTestService.testDirectProxyCall();
    }
    
    @GetMapping("/self-invocation")
    public String testSelfInvocation() {
        System.out.println("\n=== 테스트 3: Self-Invocation (자기 자신 호출) ===");
        return proxyTestService.testSelfInvocation();
    }
}