package 设计模式.观察者;

public class ConcetreObserver implements Observer{
    @Override
    public void update(String state) {
        System.out.println("观察者观察到变化 "+ state );
    }
}
