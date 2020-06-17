import java.util.ArrayList;
import java.util.List;

public class _448_FindAllNumbersDisappearedinanArray {
    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int num : nums) {
            num = Math.abs(num);
            if(nums[num - 1] < 0) continue;
            nums[num - 1] *= -1;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
