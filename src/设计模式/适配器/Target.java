package 设计模式.适配器;

/**
 * 适配器的使用类
 */
public interface Target {

    /**
     * 源220V类  adaptee有的方法
     */
    void use220V();

    /**
     * adaptee没有的方法
     */
    void use5V();


}
