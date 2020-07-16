import java.util.PriorityQueue;

public class _480_SlidingWindowMedian {
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            double[] res = new double[nums.length - k + 1];
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b.compareTo(a));
            for(int i = 0, j = 0; i < nums.length; i++) {
                minHeap.offer(nums[i]);
                maxHeap.offer(minHeap.poll());
                if(maxHeap.size() > minHeap.size()) {
                    minHeap.offer(maxHeap.poll());
                }

                if(i - j + 1 == k) {
                    double median;
                    if(minHeap.size() == maxHeap.size()) {
                        median = ((double)minHeap.peek() + (double)maxHeap.peek()) / 2.0;
                    } else {
                        median = (double)minHeap.peek();;
                    }
                    if(!minHeap.remove(nums[j])) {
                        maxHeap.remove(nums[j]);
                    }
                    res[j++] = median;
                }
            }
            return res;
        }
    }
}
