package 算法.位运算;

/**
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 借助异或的特性  a^a=0 a^0=a
 * O(n) O(1)
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }

}
