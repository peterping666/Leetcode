import java.util.ArrayList;
import java.util.List;

public class _228_SummaryRanges {
    /**
     * Time O(n)
     * Space O(n)
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while(i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if(num == nums[i]) {
                res.add(num + "");
            } else {
                res.add(num + "->" + nums[i]);
            }
        }
        return res;
    }
}
