package juc;


import java.util.concurrent.Semaphore;


public class semphore {
    static  int num = 0;
    static  int N=100;
    static Semaphore A = new Semaphore(1);
    static Semaphore B = new Semaphore(0);
    static Semaphore C = new Semaphore(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (num < N) {
                try {
                    A.acquire();
                    if(num<N){
                        System.out.println("t1: "+ num++);
                        B.release();
                    }
                } catch (InterruptedException e) {
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (num < N) {
                try {
                    B.acquire();
                    if(num<N){
                        System.out.println("t2: "+ num++);
                        C.release();
                    }
                } catch (InterruptedException e) {
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (num < N) {
                try {
                    C.acquire();
                    if(num<N){
                        System.out.println("t3: "+ num++);
                        A.release();
                    }
                } catch (InterruptedException e) {
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

}
