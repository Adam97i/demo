package juc;

public class threadLocalTest {
    private static ThreadLocal local = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        /**
         * 不同的线程 操作的虽然都是同一个local，存储的是各自的副本，线程之间互不影响
         */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + ": " + local.get());
                local.set("t1");
                System.out.println(Thread.currentThread() + ": " + local.get());
                // 每次调用threadLocal 显式清理
                local.remove();
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + ": " + local.get());
                local.set("t2");
                System.out.println(Thread.currentThread() + ": " + local.get());
                local.remove();

            }
        });

        thread1.start();
        thread2.start();
    }
}
