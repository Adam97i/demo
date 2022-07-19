package juc;

import java.util.HashMap;
import java.util.Map;

/**
 * 不同的请求  等待后被唤醒获得结果
 */
public class ResultQueue {

    private ResultQueue() {
    }

    private final static ResultQueue instance = new ResultQueue();

    public static ResultQueue getInstance() {
        return instance;
    }

    Map<String, String> map = new HashMap<>();

    /**
     * 监听队列有结果时，放入map，唤醒等待线程
     */
    public  synchronized void addResult(String key,String value) {
        this.map.put(key, value);
        this.notifyAll();
    }


    /**
     * 获取结果，没有则线程等待被唤醒, 唤醒后重新进入下一条语句，所以需要while 而不是if
     */
    public synchronized String getResult(String taskId) throws InterruptedException {
        while (!map.containsKey(taskId)) {
            System.out.println("没有结果 wait");
            this.wait();
        }
        System.out.println("我获得结果了"+ map.get(taskId));
        return map.remove(taskId);
    }



    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                ResultQueue.getInstance().getResult("111");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                ResultQueue.getInstance().getResult("000");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Thread.sleep(1000);
        new Thread(() -> {
            ResultQueue.getInstance().addResult("000", "dsa");
        }).start();

        Thread.sleep(1000);
        new Thread(() -> {
            ResultQueue.getInstance().addResult("111", "dsaaa");
        }).start();
    }
}