import java.util.ArrayList;
import java.util.List;

public class _442_FindAllDuplicatesinanArray {

    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                while(nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                }
            }
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(nums[i] != i + 1) {
                    res.add(nums[i]);
                }
            }
            return res;
        }

        private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }
}
