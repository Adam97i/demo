package juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class cas {
    public static void main(String[] args) {
        AtomicInteger c = new AtomicInteger(100);
        // 期望值相符，改为101
        c.compareAndSet(100,101);
        // 不符合，不更改
        c.compareAndSet(100,200);


        AtomicStampedReference<Integer> a = new AtomicStampedReference<>(10, 0);
        show(a);
        System.out.println(a.compareAndSet(10, 100, 0, 1));
        show(a);
        System.out.println(a.compareAndSet(100, 1000, 0, 2));
        show(a);
        // 获取旧信息
        int oldStamp = a.getStamp();
        Integer oldReference = a.getReference();
        // 修改时版本号+1
        a.compareAndSet(oldReference, 100, oldStamp, oldStamp + 1);

    }


    private static void show(AtomicStampedReference<Integer> a) {
        System.out.println("版本号：" + a.getStamp());
        System.out.println("当前值：" + a.getReference());
    }
}
