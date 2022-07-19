package 设计模式.单例;

public class DCL {
    // 构造方法私有化
    private DCL() {
    }

    // 懒汉式,静态实例，volatile防止指令重排
    private volatile static DCL instance = null;

    private static Object o = null;

    // 对外接口
    public static DCL getInstance() {
        if (instance == null) {
            synchronized (DCL.class) {
                if (instance == null) {
                    /**
                     * 指令重排带来的问题
                     * 创建对象分为3步
                     * 1.分配内存空间          memory = allocate();
                     * 2.初始化对象            instance(memory);
                     * 3.instance指向内存地址  instance = memory，此时instance != null
                     *
                     * 1 2 3 重排后 对象没初始化，但是已经分配了地址，此时instance!=null
                     * 此时另一个线程B申请获得实例，会直接返回，造成线程安全问题
                     *
                     * volatile禁用指令重排解决该问题
                     */
                    o = new Object();
                    instance = new DCL();
                }
            }
        }
        return instance;
    }

}
