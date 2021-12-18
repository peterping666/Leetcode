import java.util.PriorityQueue;

public class    _378_KthSmallestElementinaSortedMatrix {

    /**
     * Time O(nlog(diff(max-min)))
     * Space O(1)
     */
    class Solution1 {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length, left = matrix[0][0], right = matrix[n - 1][n - 1];
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (lessEqual(matrix, mid) < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        private int lessEqual(int[][] matrix, int target) {
            int n = matrix.length, count = 0, i = n - 1, j = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] <= target) {
                    count += i + 1;
                    j++;
                } else {
                    i--;
                }
            }
            return count;
        }
    }

    /**
     * Time O(klogk)
     * Space O(n^2 + k)
     */
    class Solution2 {
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            PriorityQueue<HeapNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
            boolean[][] visited = new boolean[m][n];
            minHeap.offer(new HeapNode(matrix[0][0], 0, 0));
            visited[0][0] = true;
            int[][] dirs = {{0,1}, {1,0}};

            while(--k > 0) {
                HeapNode cur = minHeap.poll();
                for(int[] dir : dirs) {
                    int x = cur.row + dir[0];
                    int y = cur.col + dir[1];
                    if(x < m && y < n && !visited[x][y]) {
                        minHeap.offer(new HeapNode(matrix[x][y], x, y));
                        visited[x][y] = true;
                    }
                }
            }
            return minHeap.poll().val;
        }

        class HeapNode {
            int val;
            int row;
            int col;
            HeapNode(int val, int row, int col) {
                this.val = val;
                this.row = row;
                this.col = col;
            }
        }
    }
}
