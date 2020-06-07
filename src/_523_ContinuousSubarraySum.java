import java.util.HashMap;

public class _523_ContinuousSubarraySum {
    /**
     * Time O(n)
     * Space O(min(n,k))
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0) {
                sum %= k;
            }
            if(map.containsKey(sum)) {
                if(i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
