package 算法.回溯;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 迷宫问题，输出唯一路径,0可走 1不可走  可以横竖走 注意是横竖，不是说只能向右或向下
 */

/**
 * dfs + backtrack
 */
public class 迷宫问题 {

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] arr = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                arr[i][j]=sc.nextInt();
//            }
//        }
        int[][] arr = new int[][]{
                {0, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 0, 0}
        };
        List<int[]> path = new ArrayList<>();
        dfs(0, 0, arr, path);

    }

    private static void dfs(int x, int y, int[][] arr, List<int[]> path) {
        // terminate
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
            return;
        }
        if (x == arr.length - 1 && y == arr[0].length - 1) {
            path.add(new int[]{x, y});
            for (int i = 0; i < path.size(); i++) {
                int[] ints = path.get(i);
                System.out.println("(" + ints[0] + "," + ints[1] + ")");
            }
            return;
        }

        // process
        if (arr[x][y] == 0) {
            path.add(new int[]{x, y});
            // 这里也要改 避免走回头路
            arr[x][y]=1;
            dfs(x + 1, y, arr, path);
            dfs(x - 1, y, arr, path);
            dfs(x, y + 1, arr, path);
            dfs(x, y - 1, arr, path);
            path.remove(path.size() - 1);
            arr[x][y]=0;
        }
    }


}