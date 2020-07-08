import java.util.PriorityQueue;

public class _295_FindMedianfromDataStream {
    class MedianFinder {

        /** initialize your data structure here. */
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((a,b) -> b - a);
        }

        /**
         * Time O(logn)
         * @param num
         */
        public void addNum(int num) {
            // Ensuring all number in maxHeap is not greater than numbers in minHeap
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());

            // Ensuring thier size differnce is less than 1
            if(maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        }

        /**
         * Time O(1)
         * @return
         */
        public double findMedian() {
            if(maxHeap.size() == minHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
            return minHeap.peek();
        }
    }
}
