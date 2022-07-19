package 设计模式.代理;

public class RealImage implements Image {
    @Override
    public void display() {
        System.out.println("原本类的展示方法");
    }
}
