package 算法.动态规划;

public class bag {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        solution(weight, value, bagsize);
    }

    /**
     * 动态规划 物品只有放入不放入两种状态，结合容量
     * dp[i][j] 第i件物品在容量为j时 背包的最大价值
     * dp[i][j]=Math.max(dp[i-1][j] ,dp[i-1][j-weight i ] + value i
     */
    private static int solution(int[] weight, int[] value, int bagsize) {
        int n = weight.length;
        // 填充边界，简化初始化步骤
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 当前背包容量小于物品容量时，沿用上一个物品时的状态
                if (j - weight[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 不放入物品 i   放入物品i  中取大
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i-1]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        return dp[n][n];

    }

}
