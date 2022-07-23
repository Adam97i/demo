package 算法.字符串;

import java.io.IOException;

/**
 * 根据子网掩码判断两个ip是否在同一个网段中
 * ip非法输出1 同一子网 0  不同子网 2
 */
public class 判断IP是否同一子网 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        String mask = sc.nextLine();
//        String ip1 = sc.nextLine();
//        String ip2 = sc.nextLine();

        String mask = "255.0.0.0";
        String ip1 ="193.194.202.15";
        String ip2 = "232.43.7.59";

        boolean maskCheck = checkMask(mask);
        boolean ip1Check = checkIp(ip1);
        boolean ip2Check = checkIp(ip2);
        if (!maskCheck || !ip1Check || !ip2Check) {
            System.out.println(1);
            return;
        }
        long maskNum = ipToNum(mask);
        long ip1Num = ipToNum(ip1);
        long ip2Num = ipToNum(ip2);
        // & 操作 会先将数值转为二进制
        if ((maskNum & ip1Num) == (maskNum & ip2Num)) {
            System.out.println(0);
        } else {
            System.out.println(2);
        }


    }

    private static long ipToNum(String ip) {
        long res=0;
        long base=1;
        String[] s = ip.split(".");
        int[] m = new int[s.length];
        for (int i =  s.length-1; i >=0; i--) {
            m[i] = Integer.parseInt(s[i]);
            res+=base*m[i];
            base*=256;
        }
        return res;
    }

    private static boolean checkMask(String mask) {
        String[] s = mask.split("\\.");
        int[] m = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            m[i] = Integer.parseInt(s[i]);
        }
        for (int i : m) {
            if (i < 0 || i > 255) {
                return false;
            }
        }
        // 掩码需要左边都是1 即每一段值都比后一段大
        return m[0] >= m[1] && m[1] >= m[2] && m[2] >= m[3];
    }

    private static boolean checkIp(String ip) {
        String[] s = ip.split("\\.");
        int[] m = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            m[i] = Integer.parseInt(s[i]);
        }
        for (int i : m) {
            if (i < 0 || i > 255) {
                return false;
            }
        }
        return true;
    }

}