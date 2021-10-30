import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class _636_ExclusiveTimeofFunctions {
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] res = new int[n];
            Deque<Log> stack = new ArrayDeque<>();
            for(String str : logs) {
                Log log = new Log(str);
                if(log.isStart) {
                    stack.push(log);
                } else {
                    Log top = stack.pop();
                    res[top.id] += log.time - top.time + 1;
                    if(!stack.isEmpty()) {
                        res[stack.peek().id] -= log.time - top.time + 1;
                    }
                }
            }
            return res;
        }

        class Log{
            int id;
            boolean isStart;
            int time;

            Log(String content) {
                String[] strs = content.split(":");
                id = Integer.valueOf(strs[0]);
                isStart = strs[1].equals("start");
                time = Integer.valueOf(strs[2]);
            }
        }
    }
    /*

     */
}
