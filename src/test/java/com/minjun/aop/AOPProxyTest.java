package com.minjun.aop;

import com.minjun.minjunlaboratory.aop.service.TestService;
import com.minjun.minjunlaboratory.MinjunLaboratoryApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
public class AOPProxyTest {
    @Mock
    private TestService testService1;

    @InjectMocks
    private TestService testService2;

    @Test
    public void testProxyVsDirectObject() {
        System.out.println("\n=== AOP 프록시 테스트 ===");
        
        System.out.println("\n1. 스프링 컨테이너에서 주입받은 객체 (프록시) 사용:");
        testService1.doSomething();
        
        System.out.println("\n2. 직접 생성한 객체 사용 (프록시 아님):");
        TestService directService = new TestService();
        directService.doSomething();
        
        System.out.println("\n=== 결과 비교 ===");
        System.out.println("프록시 객체에서는 AOP 로그가 출력됩니다.");
        System.out.println("직접 생성한 객체에서는 AOP 로그가 출력되지 않습니다.");
    }
    
    @Test
    public void testProxyType() {
        System.out.println("\n=== 프록시 타입 확인 ===");
        System.out.println("주입받은 객체 클래스: " + testService1);
        System.out.println("주입받은 객체 클래스: " + testService2);
        System.out.println("주입받은 객체 클래스: " + testService1.getClass().getName());
        System.out.println("직접 생성한 객체 클래스: " + new TestService().getClass().getName());
        
        boolean isProxy = testService1.getClass().getName().contains("$$EnhancerBySpringCGLIB$$");
        System.out.println("프록시 여부: " + isProxy);
    }
}