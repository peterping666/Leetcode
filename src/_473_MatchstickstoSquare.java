import java.util.Arrays;

public class _473_MatchstickstoSquare {
    /**
     * Time O(4^n)
     * Space O(n)
     * @param nums
     * @return
     */
    public boolean makesquare(int[] nums) {
        if(nums.length == 0) return false;
        int perimeter = 0;
        for(int num : nums) {
            perimeter += num;
        }
        Arrays.sort(nums);
        return helper(nums, perimeter / 4, new int[4], nums.length - 1);
    }

    private boolean helper(int[] nums, int side, int[] sides, int idx) {
        if(idx < 0) {
            return sides[0] == sides[1] && sides[1] == sides[2]
                    && sides[2] == sides[3] && sides[3] == side;
        }
        for(int i = 0; i < sides.length; i++) {
            if(sides[i] + nums[idx] > side) {
                continue;
            }
            sides[i] += nums[idx];
            if(helper(nums, side, sides, idx - 1)) {
                return true;
            }
            sides[i] -= nums[idx];
        }
        return false;
    }
}
