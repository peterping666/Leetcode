import java.util.ArrayList;
import java.util.List;

public class _229_MajorityElementII {
    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0) return list;
        int count1 = 0, count2 = 0, num1 = 0, num2 = 0;
        for(int num : nums) {
            if(num == num1) {
                count1++;
            } else if(num == num2) {
                count2++;
            } else if(count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if(count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        int reCount1 = 0, reCount2 = 0;
        for(int num : nums) {
            if(num == num1) reCount1++;
            else if(num == num2) reCount2++;
        }
        if(reCount1 > nums.length / 3) list.add(num1);
        if(reCount2 > nums.length / 3) list.add(num2);
        return list;
    }
}
