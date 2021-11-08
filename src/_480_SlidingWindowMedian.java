import java.util.TreeSet;

public class _480_SlidingWindowMedian {
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            TreeSet<Integer> small = new TreeSet<>((a, b)
                    -> (nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b)));
            TreeSet<Integer> large = new TreeSet<>((a, b)
                    -> (nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b)));

            double[] res = new double[nums.length - k + 1];
            int index = 0;

            for (int i = 0; i < nums.length; i++) {
                small.add(i);
                large.add(small.pollLast());
                if(large.size() > small.size()) {
                    small.add(large.pollFirst());
                }
                if (small.size() + large.size() == k) {
                    res[index] = small.size() == large.size() ? nums[small.last()] / 2.0+ nums[large.first()] / 2.0: nums[small.last()] * 1.0;
                    if (!small.remove(index)) {
                        large.remove(index);
                    }
                    index++;
                }
            }
            return res;
        }
    }
}
