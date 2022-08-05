package 算法.贪心;

import java.util.Arrays;

/**
 * * 某某公司,每天早上都有很多人去坐电梯,每个人都可能到不同的楼层.同时电梯还有一个容量限制.电梯最多只能带K个人.电梯从第a层到第b层,会花费|a-b|的时间.
 * * 现在有N个人,以及知道每个人想要去的地方,请问如何坐电梯,才能使每个人到达到他们对应的楼层,且所花费时间最少.电梯最后要会到第1层.
 *   不考虑到达某一层后的停留时间
 *
 * * 输入
 * * 3 2
 * * 2 3 4
 * * 最短时间  8
 */
public class 坐电梯 {
    /**
     * 贪心，先对目标楼层排序，优先高楼层的 （高楼层能顺带上低楼层）
     * 计算的时候只需要考虑高楼层的时间（上升/下降过程中合并掉了低楼层）
     * O(n) O(1)
     */
    public int minTime(int N, int K, int[] target) {
        int sum = 0;
        int index = target.length - 1;
        Arrays.sort(target);
        while (index >= 0) {
            // 时间= 目标楼层-1 * 往返  完成一趟后回到第一层
            int curTime = (target[index] - 1) * 2;
            sum += curTime;
            index -= K;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] target = new int[]{2, 3, 4};
        坐电梯 solution = new 坐电梯();
        int minTime = solution.minTime(3, 2, target);
        System.out.println(minTime);
    }
}
