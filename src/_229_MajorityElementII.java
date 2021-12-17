import java.util.ArrayList;
import java.util.List;

public class _229_MajorityElementII {
    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int num1 = 0, num2 = 0, cnt1 = 0, cnt2 = 0;
            for(int num : nums) {
                if(num == num1) {
                    cnt1++;
                } else if(num == num2) {
                    cnt2++;
                } else if(cnt1 == 0) {
                    num1 = num;
                    cnt1 = 1;
                } else if(cnt2 == 0) {
                    num2 = num;
                    cnt2 = 1;
                } else {
                    cnt1--;
                    cnt2--;
                }
            }
            cnt1 = 0; cnt2 = 0;
            for(int num : nums) {
                if(num1 == num) {
                    cnt1++;
                } else if(num2 == num) {
                    cnt2++;
                }
            }
            int n = nums.length;
            List<Integer> res = new ArrayList<>();
            if(cnt1 > n/3) {
                res.add(num1);
            }
            if(cnt2 > n/3) {
                res.add(num2);
            }
            return res;
        }
    }
}
