package 设计模式.单例;

/**
 * 静态内部类
 */
public class Singleton_InnerStaticClass {
    private Singleton_InnerStaticClass() {
    }

    private static class innerClass {
        private static Singleton_InnerStaticClass instance = new Singleton_InnerStaticClass();
    }

    public static Singleton_InnerStaticClass getInstance() {
        return innerClass.instance;
    }
}
