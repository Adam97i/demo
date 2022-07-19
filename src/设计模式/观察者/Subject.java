package 设计模式.观察者;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> list=new ArrayList<>();
    void detach(Observer observer){
        System.out.println("删除一个观察者");
        list.remove(observer);
    }
    void attach(Observer observer){
        System.out.println("增加一个观察者");
        list.add(observer);
    }
    /**
     * 改变方法通知所有观察者
     */
    void notifyObservers(String newState){
        System.out.println("通知观察者");
        for (Observer observer : list) {
            observer.update(newState);
        }
    }


}
