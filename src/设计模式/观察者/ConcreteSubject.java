package 设计模式.观察者;

public class ConcreteSubject extends Subject{
    private String state;
    void change(String state){
        System.out.println("改变状态");
        this.state=state;
        this.notifyObservers(state);
    }

    public static void main(String[] args) {
        // 对象
        ConcreteSubject subject = new ConcreteSubject();
        // 对象的观察者
        Observer observer = new ConcetreObserver();
        subject.attach(observer);

        // 改变通知
        subject.change("a");
    }
}
