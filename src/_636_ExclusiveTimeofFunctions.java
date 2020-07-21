import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class _636_ExclusiveTimeofFunctions {
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] res = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();
            int prevTime = 0;
            for(String log : logs) {
                String[] logInfo = log.split(":");
                int id = Integer.parseInt(logInfo[0]);
                int timestamp = Integer.parseInt(logInfo[2]);

                if (!stack.isEmpty()) {
                    res[stack.peekFirst()] += timestamp - prevTime;
                }
                prevTime = timestamp;
                if (logInfo[1].equals("start")) {
                    stack.push(id);
                } else {
                    res[stack.pollFirst()]++;
                    prevTime++;
                }
            }
            return res;
        }
    }
}
