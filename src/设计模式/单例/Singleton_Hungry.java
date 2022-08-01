package 设计模式.单例;

public class Singleton_Hungry {

    private Singleton_Hungry() {
    }

    private static Singleton_Hungry instance=new Singleton_Hungry();

    public static Singleton_Hungry getInstance() {
        return instance;
    }
}