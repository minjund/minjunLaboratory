package com.minjun.minjunlaboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MinjunLaboratoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinjunLaboratoryApplication.class, args);
    }

}
