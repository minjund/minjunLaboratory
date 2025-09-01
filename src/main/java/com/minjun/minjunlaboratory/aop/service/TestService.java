package com.minjun.minjunlaboratory.aop.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    
    public String doSomething() {
        System.out.println("💼 실제 비즈니스 로직 실행");
        return "작업 완료";
    }
    
    public String doAnotherThing() {
        System.out.println("🚀 또 다른 비즈니스 로직 실행");
        return "또 다른 작업 완료";
    }
}