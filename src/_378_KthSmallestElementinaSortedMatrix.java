import java.util.PriorityQueue;

public class    _378_KthSmallestElementinaSortedMatrix {
    /**
     * Time O(klogk)
     * Space O(k)
     * @return
     */
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            PriorityQueue<HeapNode> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
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
