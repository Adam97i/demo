

import java.util.*;
import java.util.stream.Collectors;



public class Lesson {


    private String lessonId;

    private String courseId;

    Lesson() {
        String s = "abc".intern();
    }

    Lesson(String i) {
        this.lessonId = i;
    }

    public static void main(String[] args) {
        // 对二维数组进行升序排序，行相等则比较列,
        List<int[]> list = new ArrayList<>();
        list.stream().sorted((a, b) -> {
            int r1 = a[0] - b[0];
            return r1 == 0 ? a[1] - b[1] : r1;
        }).collect(Collectors.toList());
        Set<Integer> set = new TreeSet<>((a, b) -> b - a);
        int[] a=new int[]{1,2,3};
        Map<String,String> map=new HashMap<>();
        map.put(null,null);
        map.put(null,null);

    }

    public static void test() {
        try {
            System.exit(1);
        } finally {
            System.out.println("finally被执行");
        }
    }

}

