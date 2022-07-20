package jvm;

/**
 * BootStrapClassLoader  <-  ExtensionClassLoader   <-  ApplicationClassLoader
 */
public class 类加载器 {
    public static void main(String[] args) {
        // application classloader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        System.out.println(extensionClassLoader);

        /**
         * BootStrap ClassLoader 是JVM的一部分，C/C++编写 不属于java 返回null
         *     =>   为null的classLoader 代表类加载为BootStrap ClassLoader
         */
        ClassLoader BootStrapClassLoader = extensionClassLoader.getParent();
        System.out.println(BootStrapClassLoader);
    }
}
