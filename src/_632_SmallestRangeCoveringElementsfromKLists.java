import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _632_SmallestRangeCoveringElementsfromKLists {
    /**
     * Time O(nlogk)
     * Space O(k)
     */
    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            Queue<Node> heap = new PriorityQueue<>((a, b) -> (a.list.get(a.idx).compareTo(b.list.get(b.idx))));
            int large = 0;
            for(int i = 0; i < nums.size(); i++) {
                heap.offer(new Node(nums.get(i), 0));
                large = Math.max(large, nums.get(i).get(0));
            }
            int[] res = new int[]{0, Integer.MAX_VALUE};
            while(!heap.isEmpty()) {
                Node cur = heap.poll();
                int small = cur.list.get(cur.idx);
                if(large - small < res[1] - res[0]) {
                    res[0] = small;
                    res[1] = large;
                }
                List<Integer> list = cur.list;
                if(++cur.idx == list.size()) {
                    break;
                }
                large = Math.max(large, cur.list.get(cur.idx));
                heap.offer(cur);
            }
            return res;
        }

        class Node{
            List<Integer> list;
            int idx;

            Node(List<Integer> l, int i) {
                list = l;
                idx = i;
            }
        }
    }
}
