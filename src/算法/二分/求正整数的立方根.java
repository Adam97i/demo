package 算法.二分;

/**
 * 不使用math函数
 * way 1 二分查找
 * way 2 牛顿迭代法
 */
public class 求正整数的立方根 {
    public double getRes(int n) {
        double l = 0;
        double r = n;
        while (r - l > 0.0001) {
            double m = (l + r) / 2;
            if (m * m * m <= n) {
                l = m;
            } else {
                r = m;
            }
        }
        System.out.println(l);
        return l;
    }

    public static void main(String[] args) {
        求正整数的立方根 cur = new 求正整数的立方根();
        cur.getRes(10);
        cur.getRes(100);
        cur.getRes(27);
        cur.getRes(5);
    }
}
