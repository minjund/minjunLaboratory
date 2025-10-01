package com.minjun.minjunlaboratory.threadlocal;

public class ThreadLocalExemple {

    public static void main(String[] args) {
        ThreadLocal<String> normalLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableLocal = new InheritableThreadLocal<String>();

        // 부모 스레드에서 값 설정
        normalLocal.set("부모의 일반 데이터");
        inheritableLocal.set("부모의 상속 가능 데이터");

        System.out.println("=== 부모 스레드 ===");
        System.out.println("normalLocal: " + normalLocal.get());
        System.out.println("inheritableLocal: " + inheritableLocal.get());

        // 자식 스레드 생성
        new Thread(() -> {
            System.out.println("\n=== 자식 스레드 ===");

            // 일반 ThreadLocal - null! (상속 안 됨)
            System.out.println("normalLocal: " + normalLocal.get());

            // InheritableThreadLocal - 값 있음! (상속됨)
            System.out.println("inheritableLocal: " + inheritableLocal.get());

        }).start();
    }
}
