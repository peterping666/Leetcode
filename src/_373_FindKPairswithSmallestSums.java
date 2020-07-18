import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _373_FindKPairswithSmallestSums {
    class Solution {
        /**
         * Time O(klogk)
         * Space O(k)
         * @param nums1
         * @param nums2
         * @param k
         * @return
         */
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> lists = new ArrayList<>();
            if(nums1.length == 0 || nums2.length == 0) {
                return lists;
            }
            PriorityQueue<List<Integer>> heap = new PriorityQueue<>(
                    (a,b) -> Integer.compare(a.get(0) + a.get(1), b.get(0) + b.get(1)));
            for(int i = 0; i < nums2.length && i < k; i++) {
                heap.offer(new ArrayList<>(Arrays.asList(nums1[0], nums2[i], 0)));
            }
            while(!heap.isEmpty() && k-- > 0) {
                List<Integer> cur = heap.poll();
                lists.add(new ArrayList<>(Arrays.asList(cur.get(0), cur.get(1))));
                if(cur.get(2) == nums1.length - 1) {
                    continue;
                }
                heap.offer(new ArrayList<>(Arrays.asList(nums1[cur.get(2) + 1], cur.get(1), cur.get(2) + 1)));
            }
            return lists;
        }
    }
}
