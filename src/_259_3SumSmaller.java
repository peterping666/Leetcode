import java.util.Arrays;

public class _259_3SumSmaller {
    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length, res = 0;
            for(int i = 0; i < n; i++) {
                int left = i + 1, right = n - 1;
                while(left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum < target) {
                        res += right - left;
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return res;
        }
    }
}
