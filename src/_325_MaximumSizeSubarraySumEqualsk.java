import java.util.HashMap;

public class _325_MaximumSizeSubarraySumEqualsk {
    /**
     * Time O(n)
     * Space O(n)
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if(map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return res;
    }
}
