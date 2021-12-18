import java.util.*;

public class _373_FindKPairswithSmallestSums {
    /**
     * Time O(klogn)
     * Space O(n)
     */
    class Solution1 {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int m = nums1.length, n = nums2.length;
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                    (a,b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));
            for(int i = 0; i < n; i++) {
                minHeap.offer(new int[]{nums1[0], nums2[i], 0});
            }
            List<List<Integer>> res = new ArrayList<>();
            while(k-- > 0 && !minHeap.isEmpty()) {
                int[] cur = minHeap.poll();
                res.add(Arrays.asList(cur[0], cur[1]));
                int i = cur[2];
                if(i + 1 < m) {
                    minHeap.offer(new int[]{nums1[i+1], cur[1], i+1});
                }
            }
            return res;
        }
    }

    /**
     * Time O(klogk)
     * Space O(mn + k)
     */
    class Solution2 {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            Queue<Node> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
            minHeap.offer(new Node(nums1[0]+nums2[0], 0, 0));
            int[][] dirs = {{0,1}, {1,0}};
            List<List<Integer>> res = new ArrayList<>();
            int m = nums1.length, n = nums2.length;
            boolean[][] seen = new boolean[m][n];
            seen[0][0] = true;
            while(k-- > 0 && !minHeap.isEmpty()) {
                Node cur = minHeap.poll();
                res.add(Arrays.asList(nums1[cur.i], nums2[cur.j]));
                for(int[] dir : dirs) {
                    int x = dir[0] + cur.i;
                    int y = dir[1] + cur.j;
                    if(x < m && y < n && !seen[x][y]) {
                        minHeap.offer(new Node(nums1[x]+nums2[y], x, y));
                        seen[x][y] = true;
                    }
                }
            }
            return res;
        }

        class Node {
            int val;
            int i;
            int j;
            Node(int val, int i, int j) {
                this.val = val;
                this.i = i;
                this.j = j;
            }
        }
    }
}
