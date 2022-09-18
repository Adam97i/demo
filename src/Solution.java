import java.util.HashMap;
import java.util.Map;

public class Solution {

    // O(n) O(n)
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int n=nums.length;

        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            if(entry.getValue()>n/2){
                return entry.getKey();
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    }
}
