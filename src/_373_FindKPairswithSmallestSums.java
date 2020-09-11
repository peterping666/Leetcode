import java.util.*;

public class _373_FindKPairswithSmallestSums {
    /**
     * Time O(klogk)
     * Space O(k)
     * @return
     */
    class Solution1 {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> lists = new ArrayList<>();
            if(nums1.length == 0 || nums2.length == 0) {
                return lists;
            }
            PriorityQueue<List<Integer>> heap = new PriorityQueue<>(
                    (a,b) -> Integer.compare(a.get(0) + a.get(1), b.get(0) + b.get(1)));
            for(int i = 0; i < nums2.length && i < k; i++) {
                heap.offer(new ArrayList<>(Arrays.asList(nums1[0], nums2[i], 0)));
            }
            while(!heap.isEmpty() && k-- > 0) {
                List<Integer> cur = heap.poll();
                lists.add(new ArrayList<>(Arrays.asList(cur.get(0), cur.get(1))));
                if(cur.get(2) == nums1.length - 1) {
                    continue;
                }
                heap.offer(new ArrayList<>(Arrays.asList(nums1[cur.get(2) + 1], cur.get(1), cur.get(2) + 1)));
            }
            return lists;
        }
    }

    /**
     * Time O(2k * log(2k))
     * Space O(2k)
     */
    class Solution2 {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if(nums1.length == 0 || nums2.length == 0) {
                return res;
            }
            Queue<List<Integer>> minHeap =
                    new PriorityQueue<>((a, b) -> Integer.compare(a.get(0), b.get(0)));

            minHeap.offer(Arrays.asList(nums1[0] * nums2[0], 0, 0));
            boolean[][] visited = new boolean[nums1.length][nums2.length];
            visited[0][0] = true;
            while(k > 0 && !minHeap.isEmpty()) {
                List<Integer> cur = minHeap.poll();
                int x = cur.get(1);
                int y = cur.get(2);
                res.add(Arrays.asList(nums1[x], nums2[y]));
                if(x + 1 < nums1.length && !visited[x + 1][y]) {
                    minHeap.offer(Arrays.asList(nums1[x + 1] + nums2[y], x + 1, y));
                    visited[x + 1][y] = true;
                }
                if(y + 1 < nums2.length && !visited[x][y + 1]) {
                    minHeap.offer(Arrays.asList(nums1[x] + nums2[y + 1], x, y + 1));
                    visited[x][y + 1] = true;
                }
                k--;
            }
            return res;
        }
    }
}
