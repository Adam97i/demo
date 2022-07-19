package 设计模式.适配器;

// 继承/组合 不兼容的类，实现需要的方法
public class Adapter extends Power220V implements Target {


    @Override
    public void use5V() {
        System.out.println("调用5V接口");
    }

    @Override
    public void use220V() {
        super.use220V();
    }

    public static void main(String[] args) {
        Target t =new Adapter();
        t.use5V();
        t.use220V();
    }
}
