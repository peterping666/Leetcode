import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _379_DesignPhoneDirectory {
    class PhoneDirectory {

        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        Queue<Integer> queue;
        HashSet<Integer> set;
        public PhoneDirectory(int maxNumbers) {
            queue = new LinkedList<>();
            for(int i = 0; i < maxNumbers; i++) {
                queue.offer(i);
            }
            set = new HashSet<>(queue);
        }

        /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
        public int get() {
            if(queue.isEmpty()) return -1;
            int val = queue.poll();
            set.remove(val);
            return val;
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            return set.contains(number);
        }

        /** Recycle or release a number. */
        public void release(int number) {
            if(!set.contains(number)) {
                queue.offer(number);
                set.add(number);
            }

        }
    }

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
}
