import java.util.ArrayList;
import java.util.List;

public class _228_SummaryRanges {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList<>();
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
}
