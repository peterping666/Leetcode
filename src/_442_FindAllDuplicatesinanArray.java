import java.util.ArrayList;
import java.util.List;

public class _442_FindAllDuplicatesinanArray {
    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            num = Math.abs(num);
            if(nums[num - 1] < 0) {
                list.add(num);
            }
            nums[num - 1] *= -1;
        }
        return list;
    }
}
