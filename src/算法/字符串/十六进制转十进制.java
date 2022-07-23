package 算法.字符串;

import java.io.IOException;
import java.util.Scanner;

/**
 * 十六进制转十进制输出
 */
public class 十六进制转十进制 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            String num = input.substring(2);
            int res = 0;
            int base = 1;
            for (int i = num.length() - 1; i >= 0; i--) {
                char c = num.charAt(i);
                int value = 0;
                if (Character.isDigit(c)) {
                    value = c-'0';
                } else {
                    value = c - 'A' + 10;
                }
                res += value * base;
                base *= 16;
            }
            System.out.println(res);
        }
    }
}