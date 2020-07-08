import java.util.LinkedList;
import java.util.Queue;

public class _346_MovingAveragefromDataStream {
    class MovingAverage {

        /** Initialize your data structure here. */
        private Queue<Integer> queue;
        private int capasity;
        private double sum;
        public MovingAverage(int size) {
            queue = new LinkedList<>();
            capasity = size;
            sum = 0;
        }

        public double next(int val) {
            queue.offer(val);
            sum += val;
            if(queue.size() > capasity) {
                sum -= queue.poll();
            }
            return sum / queue.size();
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
