package collection;

import java.util.ArrayList;

/**
 * arraylist扩容测试
 */
public class array {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            list.add(i);
        }

    }
}
