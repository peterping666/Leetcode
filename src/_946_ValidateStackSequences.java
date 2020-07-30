import java.util.ArrayDeque;
import java.util.Deque;

public class _946_ValidateStackSequences {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new ArrayDeque<>();
            int index = 0;
            for(int num : pushed) {
                stack.offerFirst(num);
                while(!stack.isEmpty() && popped[index] == stack.peekFirst()) {
                    stack.pollFirst();
                    index++;
                }
            }
            return stack.isEmpty();
        }
    }
}
