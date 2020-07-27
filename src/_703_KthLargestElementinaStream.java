import java.util.PriorityQueue;
import java.util.Queue;

public class _703_KthLargestElementinaStream {
    class KthLargest {

        private Queue<Integer> minHeap;
        private int k;
        public KthLargest(int k, int[] nums) {
            minHeap = new PriorityQueue<>();
            this.k = k;
            for(int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if(minHeap.size() < k) {
                minHeap.offer(val);
            } else if(minHeap.peek() < val) {
                minHeap.poll();
                minHeap.offer(val);
            }
            return minHeap.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
