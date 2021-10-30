import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _1762_BuildingsWithanOceanView {
    class Solution1 {
        public int[] findBuildings(int[] heights) {
            List<Integer> list = new ArrayList<>();
            for(int i = heights.length - 1; i >= 0; i--) {
                if(list.isEmpty() || heights[i] > heights[list.get(list.size() - 1)]) {
                    list.add(i);
                }
            }
            int n = list.size();
            int[] res = new int[n];
            for(int i = 0; i < res.length; i++) {
                res[i] = list.get(n - i - 1);
            }
            return res;
        }
    }

    class Solution2 {
        public int[] findBuildings(int[] heights) {
            Deque<Integer> deque = new ArrayDeque<>();
            for(int i = 0; i < heights.length; i++) {
                while(!deque.isEmpty() && heights[deque.peekLast()] <= heights[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            int[] res = new int[deque.size()];
            for(int i = 0; i < res.length; i++) {
                res[i] = deque.pollFirst();
            }
            return res;
        }
    }
}
