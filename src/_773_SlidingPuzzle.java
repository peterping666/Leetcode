import java.util.HashSet;
import java.util.LinkedList;
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
            Queue<String> queue = new LinkedList<>();
            HashSet<String> seen = new HashSet<>();
            queue.offer(start);
            seen.add(start);
            int[][] dirs = {{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};
            int res = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    if(cur.equals(target)) {
                        return res;
                    }
                    int zero = cur.indexOf('0');
                    for(int index : dirs[zero]) {
                        String next = swap(cur, zero, index);
                        if(seen.add(next)) {
                            queue.offer(next);
                        }
                    }
                }
                res++;
            }
            return -1;
        }

        private String swap(String str, int zero, int index) {
            StringBuilder sb = new StringBuilder(str);
            sb.setCharAt(zero, str.charAt(index));
            sb.setCharAt(index, str.charAt(zero));
            return sb.toString();
        }
    }
}
