package collection;

import java.util.ArrayList;

public class array {
    public static void main(String[] args) {
        // arraylist扩容测试
        ArrayList<Integer> list = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            list.add(i);
        }

        // forEach
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("111");
        list2.add("222");
        list2.add("333");
        // 普通for可以修改
        for (int i = 0; i <list2.size(); i++) {
            list2.remove("222");
        }
        // 增强for 锁定集合，不能修改删除元素，抛出CME
        for(String i: list2){
            list2.remove(i);
        }
    }
}
