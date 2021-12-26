import java.util.ArrayDeque;
import java.util.Deque;

public class _946_ValidateStackSequences {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new ArrayDeque<>();
            int i = 0;
            for(int num : pushed) {
                stack.push(num);
                while(!stack.isEmpty() && stack.peek() == popped[i]) {
                    stack.pop();
                    i++;
                }
            }
            return stack.isEmpty();
        }
    }
}
