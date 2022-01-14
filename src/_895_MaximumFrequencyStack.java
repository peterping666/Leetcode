import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class _895_MaximumFrequencyStack {
    class FreqStack {

        Map<Integer, Deque<Integer>> freqToStack;
        Map<Integer, Integer> freq;
        int maxFreq;

        public FreqStack() {
            freqToStack = new HashMap<>();
            freq = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int val) {
            int count = freq.getOrDefault(val, 0) + 1;
            freq.put(val, count);
            freqToStack.putIfAbsent(count, new ArrayDeque<>());
            freqToStack.get(count).push(val);
            maxFreq = Math.max(maxFreq, count);
        }

        public int pop() {
            Deque<Integer> stack = freqToStack.get(maxFreq);
            int res = stack.pop();
            freq.put(res, maxFreq - 1);
            if(stack.isEmpty()) {
                maxFreq--;
            }
            return res;
        }
    }
}
