import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _349_IntersectionofTwoArrays {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution1 {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set = new HashSet<>();
            for(int num : nums1) {
                set.add(num);
            }
            List<Integer> list = new ArrayList<>();
            for(int num : nums2) {
                if(set.contains(num)) {
                    list.add(num);
                    set.remove(num);
                }
            }
            int[] ans = new int[list.size()];
            for(int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }

    /**
     * Time O(nlogn)
     * Space O(1)
     */
    class Solution2 {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int p1 = 0, p2 = 0;
            List<Integer> list = new ArrayList<>();
            while(p1 < nums1.length && p2 < nums2.length) {
                if(nums1[p1] == nums2[p2]) {
                    list.add(nums1[p1]);
                    p1++;
                    p2++;
                } else if(nums1[p1] > nums2[p2]) {
                    p2++;
                } else {
                    p1++;
                }
                while(p1 < nums1.length && p1 != 0 && nums1[p1] == nums1[p1 - 1]) {
                    p1++;
                }
                while(p2 < nums2.length && p2 != 0 && nums2[p2] == nums2[p2 - 1]) {
                    p2++;
                }
            }
            int[] ans = new int[list.size()];
            for(int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
}
