import java.util.*;

public class _279_PerfectSquares {
    class Solution {
        public int numSquares(int n) {
            HashSet<Integer> perfectNums = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            HashMap<Integer, Integer> seen = new HashMap<>();
            for(int i = 1; i * i <= n; i++) {
                perfectNums.add(i * i);
            }
            q.offer(n);
            seen.put(n, 1);
            while(!q.isEmpty()) {
                int cur = q.poll();
                if(perfectNums.contains(cur)) {
                    return seen.get(cur);
                }
                for(int num : perfectNums) {
                    int newNum = cur - num;
                    if(!seen.containsKey(newNum) && newNum > 0) {
                        q.offer(newNum);
                        seen.put(newNum, seen.get(cur) + 1);
                    }
                }
            }
            return -1;
        }
    }
}
