import java.util.TreeSet;

public class _480_SlidingWindowMedian {
    /**
     * Time O(nlogk)
     */
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            double[] res = new double[n - k + 1];
            TreeSet<Integer> small = new TreeSet<>(
                    (a,b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b));
            TreeSet<Integer> large = new TreeSet<>(
                    (a,b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b));

            for(int i = 0; i < n; i++) {
                small.add(i);
                large.add(small.pollLast());
                if(large.size() > small.size()) {
                    small.add(large.pollFirst());
                }
                if(small.size() + large.size() >= k) {
                    int j = i - k + 1;
                    res[j] = k % 2 == 0 ?
                            (nums[small.last()] / 2.0 + nums[large.first()] / 2.0) : nums[small.last()];
                    if(!small.remove(j)) {
                        large.remove(j);
                    }
                }
            }
            return res;
        }
    }
}
