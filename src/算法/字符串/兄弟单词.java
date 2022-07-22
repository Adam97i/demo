package 算法.字符串;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/**
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
 * 现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
 * 注意：字典中可能有重复单词。
 * <p>
 * 数据范围：1 \le n \le 1000 \1≤n≤1000 ，输入的字符串长度满足 1 \le len(str) \le 10 \1≤len(str)≤10  ， 1 \le k < n \1≤k<n
 * 3 abc bca cab abc 1
 */

/**
 * 判断是否是兄弟单词，是的话放入List
 */
public class 兄弟单词 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        String target = sc.next();
        int k = sc.nextInt();

        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }
        List<String> list = new ArrayList<>();
        for (String str : strs) {
            if (isBrother(str, target, targetCount)) {
                list.add(str);
            }
        }
        /**
         * list字典序排序
         */
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1=o1.length(),len2=o2.length();
                for (int i = 0; i < Math.min(len1, len2); i++) {
                    if(o1.charAt((i))==o2.charAt(i)){
                        continue;
                    }else {
                        return o1.charAt(i)-o2.charAt(i);
                    }
                }
                if(len1<len2){
                    return -1;
                }
                return 1;
            }
        });
        System.out.println(list.size());
        if(k-1<list.size()){
            System.out.println(list.get(k-1));
        }
    }

    private static boolean isBrother(String str, String target, int[] targetCount) {
        if (str.equals(target)) {
            return false;
        }
        int[] count=new int[26];
        for (char c : str.toCharArray()) {
            count[c-'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i]!=targetCount[i]){
                return false;
            }
        }
        return true;
    }

}