package 设计模式.代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理，多种扩展用一个通用处理器指定目标类    而不是多个代理类
 * <p>
 * InvocationHandler JDK动态代理接口，生成接口的所有方法
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object obj;

    /**
     * 指定目标类，创建处理器
     *
     * @param targetObj 代理的目标类
     */
    public DynamicProxyHandler(Object targetObj) {
        this.obj = targetObj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return method.invoke(this.obj, objects);
    }

    public static void main(String[] args) {
        // 目标类
        Image image = new RealImage();
        // 根据目标类产生handler
        DynamicProxyHandler handler = new DynamicProxyHandler(image);
        // 接口的加载器
        ClassLoader classLoader = image.getClass().getClassLoader();

        // 接口加载器，接口，目标类处理器
        Image proxy = (Image) Proxy.newProxyInstance(classLoader, new Class[]{Image.class}, handler);

        proxy.display();

        Image image2 = new RealImage2222();
        DynamicProxyHandler handler2 = new DynamicProxyHandler(image2);
        Image proxy2 = (Image) Proxy.newProxyInstance(classLoader, new Class[]{Image.class}, handler2);
        proxy2.display();
    }
}
