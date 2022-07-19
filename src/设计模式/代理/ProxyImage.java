package 设计模式.代理;

/**
 * 代理类 依赖原本类，并且实现同一个接口 达到代理效果
 * 并且能够对方法进行扩展，切面编程
 */
public class ProxyImage implements Image {

    RealImage realImage;

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage();
        }
        System.out.println("在调用方法前扩展");
        System.out.println();

        System.out.println("代理类调用了原本类的方法");
        realImage.display();
        System.out.println();
        System.out.println("在调用方法后扩展");

    }

    public static void main(String[] args) {
        Image image = new ProxyImage();
        image.display();
    }
}
