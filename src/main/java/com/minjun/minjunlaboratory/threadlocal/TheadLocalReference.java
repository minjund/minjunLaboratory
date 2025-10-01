package com.minjun.minjunlaboratory.threadlocal;

import java.lang.ref.WeakReference;

public class TheadLocalReference {

    static class Entry extends WeakReference<ThreadLocal<?>> {
        Object value;  // ⚠️ 이건 Strong Reference!

        public Entry(ThreadLocal<?> referent) {
            super(referent);
        }
    }

    void showTheProblem() {
        ThreadLocal<byte[]> local = new ThreadLocal<>();

        // 1GB 데이터 저장
        byte[] bigData = new byte[1024 * 1024 * 1024];
        local.set(bigData);

        // ThreadLocal 참조 제거
        local = null;
        bigData = null;

        System.gc();

        // 결과:
        // - ThreadLocal 객체(키): GC됨 ✅
        // - 1GB 데이터(값): 여전히 메모리에 남음! ❌

        // Entry.key는 null이 되었지만
        // Entry.value는 여전히 strong reference!
    }
}