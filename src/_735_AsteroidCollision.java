import java.util.ArrayDeque;
import java.util.Deque;

public class _735_AsteroidCollision {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> deque = new ArrayDeque<>();
            for(int a : asteroids) {
                if(a > 0) {
                    deque.offerLast(a);
                } else {
                    while(!deque.isEmpty() && deque.peekLast() > 0 && a != 0) {
                        int cur = deque.pollLast();
                        if(cur == -a) {
                            a = 0;
                        } else if(cur > -a) {
                            a = 0;
                            deque.offerLast(cur);
                        }
                    }
                    if(a != 0) {
                        deque.offerLast(a);
                    }
                }
            }
            int[] res = new int[deque.size()];
            for(int i = 0; i < res.length; i++) {
                res[i] = deque.pollFirst();
            }
            return res;
        }
    }
}
