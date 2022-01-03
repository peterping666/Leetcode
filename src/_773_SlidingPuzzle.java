import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class _773_SlidingPuzzle {
    class Solution {
        public int slidingPuzzle(int[][] board) {
            String target = "123450";
            String start = "";
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    start += board[i][j];
                }
            }
            if(start.equals(target)) {
                return 0;
            }
            Queue<String> queue = new ArrayDeque<>();
            Map<String, Integer> map = new HashMap<>();
            queue.offer(start);
            map.put(start, 0);
            int[][] dirs = {{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};
            while(!queue.isEmpty()) {
                String cur = queue.poll();
                int zero = cur.indexOf('0');
                for(int index : dirs[zero]) {
                    String next = swap(cur, zero, index);
                    if(next.equals(target)) {
                        return map.get(cur) + 1;
                    }
                    if(!map.containsKey(next)) {
                        queue.offer(next);
                        map.put(next, map.get(cur) + 1);
                    }
                }
            }
            return -1;
        }

        private String swap(String str, int zero, int index) {
            char[] arr = str.toCharArray();
            char tmp = arr[zero];
            arr[zero] = arr[index];
            arr[index] = tmp;
            return new String(arr);
        }
    }
}
