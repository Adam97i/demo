package 算法.动态规划;


import java.util.Scanner;

public class bag2 {

    /**
     * 动态规划 01背包问题 dp[n][money]  计算满意度
     * dp[i][j]
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int n = sc.nextInt();
        good[] goodList = new good[n + 1];
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            goodList[i] = new good(v, p, q);
        }

        for (int i = 1; i <= n; i++) {
            // 附件的话更新主件
            if (goodList[i].q > 0) {
                good good = goodList[goodList[i].q];
                if (good.a1 == 0) {
                    good.a1 = i;
                } else {
                    good.a2 = i;
                }
            }
        }

        int[][] dp = new int[n + 1][money + 1];
        for (int i = 1; i <= n; i++) {
            // 计算四种方案及其期望
            // 主件 主件+附件1 主件+附件2  主件+附件1+附件2
            int v = 0, v1 = 0, v2 = 0, v3 = 0;
            int tmp = 0, tmp1 = 0, tmp2 = 0, tmp3 = 0;
            good cur = goodList[i];
            v = cur.v;
            tmp = cur.getM();
            if (cur.a1 != 0) {
                v1 = v + goodList[cur.a1].v;
                tmp1 = tmp + goodList[cur.a1].getM();
            }
            if (cur.a2 != 0) {
                v2 = v + goodList[cur.a2].v;
                tmp2 = tmp + goodList[cur.a2].getM();
            }
            if (cur.a1 != 0 && cur.a2 != 0) {
                v3 = v + goodList[cur.a1].v + goodList[cur.a2].v;
                tmp3 = tmp + goodList[cur.a1].getM() + goodList[cur.a2].getM();
            }

            for (int j = 1; j <= money; j++) {
                // 如果是附件则跳过
                if (goodList[i].q > 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= v && v != 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v] + tmp);
                    if (j >= v1 && v1 != 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v1] + tmp1);
                    if (j >= v2 && v2 != 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v2] + tmp2);
                    if (j >= v3 && v3 != 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v3] + tmp3);
                }
            }

        }
        System.out.println(dp[n][money]);


    }

    public static class good {

        // 价格
        int v;
        // 重要度
        int p;
        // 商品id
        int q;
        // 因为商品只会有 0  1  2 附件组合，嵌在主类里
        // 附件id
        int a1 = 0;
        int a2 = 0;

        public good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public int getM() {
            return v * p;
        }


    }
}