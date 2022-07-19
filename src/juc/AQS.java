package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class AQS {


    /**
     * 信号量
     */
//    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(300);
//        Semaphore semaphore = new Semaphore(5);
//        for (int i = 0; i < 100; i++) {
//            int finali = i;
//            threadPool.execute(() -> {
//                try {
//                    semaphore.acquire();
//                    System.out.println("Index:" + finali);
//                    Thread.sleep(2000);
//                    semaphore.release();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//        threadPool.shutdown();
//    }

    /**
     * CountDownLatch
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 100; i++) {
            int finali = i;
            threadPool.execute(() -> {
                System.out.println("Index:" + finali);
                // 每次-1
                countDownLatch.countDown();
            });
        }
        // 等待为countDownLatch为0 时执行
        countDownLatch.await();
        System.out.println("countDownLatch 为0 ，可执行");
        threadPool.shutdown();
    }

}
