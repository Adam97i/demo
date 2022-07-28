package 算法.排序;

import java.util.*;
import java.util.stream.Collectors;

public class comparator {
    public static void main(String[] args) {
        // 对二维数组进行升序排序，行相等则比较列,
        List<int[]> list = new ArrayList<>();
        list.stream().sorted((a, b) -> {
            int r1 = a[0] - b[0];
            return r1 == 0 ? a[1] - b[1] : r1;
        }).collect(Collectors.toList());

        Collections.sort(list, (a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : a[1] - b[1]);
        Collections.sort(list, (a, b) -> {
            int r1 = a[0] - b[0];
            return r1 != 0 ? r1 : a[1] - b[1];
        });
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
    }
}
