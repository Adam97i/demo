package jmm;

public class sync {
    public static void main(String[] args) {
        synchronized (sync.class){
            System.out.println("sync");
        }
    }
}
