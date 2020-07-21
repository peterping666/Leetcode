import java.util.ArrayDeque;
import java.util.Deque;

public class _735_AsteroidCollision {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new ArrayDeque<>();
            for(int ast : asteroids) {
                boolean push = true;
                while(!stack.isEmpty() && ast < 0 && stack.peekFirst() > 0) {
                    if(stack.peekFirst() < -ast) {
                        stack.pollFirst();
                    } else {
                        if(stack.peekFirst() == -ast) {
                            stack.pollFirst();
                        }
                        push = false;
                        break;
                    }
                }
                if(push) {
                    stack.offerFirst(ast);
                }
            }

            int[] res = new int[stack.size()];
            for(int i = res.length - 1; i >= 0; i--) {
                res[i] = stack.pollFirst();
            }
            return res;
        }
    }
}
