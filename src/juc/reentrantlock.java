package juc;

import java.util.concurrent.Semaphore;

// 通过信号量实现三个线程交替打印0-99

public class reentrantlock {
    static Thread t1, t2, t3;
    static volatile int i = 0;
    static int N = 99;

    static Semaphore A = new Semaphore(1);
    static Semaphore B = new Semaphore(0);
    static Semaphore C = new Semaphore(0);

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            while (i <= N) {
                try {
                    A.acquire();
                    // 这边需要再次判断
                    if (i <= N) {
                        System.out.println("t1 :" + (i++));
                    }
                    B.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t2 = new Thread(() -> {
            while (i <= N) {
                try {
                    B.acquire();
                    if (i <= N) {
                        System.out.println("t2 :" + (i++));
                    }
                    C.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t3 = new Thread(() -> {
            while (i <= N) {
                try {
                    C.acquire();
                    if (i <= N) {
                        System.out.println("t3 :" + (i++));
                    }
                    A.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();


    }

}
