package 算法.回溯;

import java.io.IOException;

/**
 * 二十四点，每个数字只能使用一次
 * <p>
 * dfs + backtrack
 * visited数组记录访问
 */
public class 二十四点 {
    static boolean[] visit = new boolean[4];
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        int[] nums = new int[]{7, 9, 10, 9};
//        Scanner sc = new Scanner(System.in);
//        int[] nums = new int[4];
//        for (int i = 0; i <4; i++) {
//            nums[i]=sc.nextInt();
//        }
        for (int i = 0; i < nums.length; i++) {
            visit[i] = true;
            dfs(nums[i], 1, nums);
            visit[i] = false;
        }
        System.out.println(flag);
    }

    private static void dfs(double cur, int count, int[] nums) {
        // terminate
        if (count == 4 && cur == 24) {
            flag = true;
        }
        // process
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                int val = nums[i];
                visit[i] = true;
                dfs(cur + val, count + 1, nums);
                dfs(cur - val, count + 1, nums);
                dfs(cur * val, count + 1, nums);
                dfs(cur / val, count + 1, nums);
                visit[i] = false;
            }
        }
    }
}