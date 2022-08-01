package 设计模式.单例;

public class Singleton_DCL {
    // 构造方法私有化
    private Singleton_DCL() {
    }

    // 静态变量
    private static volatile Singleton_DCL instance = null;

    // 静态方法获得
    public static Singleton_DCL getInstance() {
        if (instance == null) {
            synchronized (Singleton_DCL.class) {
                if (instance == null) {
                    instance = new Singleton_DCL();
                }
            }
        }
        return instance;
    }

}
