import java.util.Comparator;
import java.util.PriorityQueue;

public class _378_KthSmallestElementinaSortedMatrix {
    /**
     * Time O(X + KlogX) X = min(K, N)
     * Space O(X)
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<HeapNode> heap = new PriorityQueue<>(new HeapComparator());
//        PriorityQueue<HeapNode> heap = new PriorityQueue<>(new Comparator<HeapNode>() {
//            @Override
//            public int compare(HeapNode a, HeapNode b) {
//                return a.val - b.val;
//            }
//        });
        for(int i = 0; i < matrix[0].length; i++) {
            heap.offer(new HeapNode(matrix[0][i], 0, i));
        }
        for(int i = 0; i < k - 1; i++) {
            HeapNode minNode = heap.poll();
            int row = minNode.row + 1;
            if(row >= matrix.length) continue;
            int col = minNode.col;
            heap.offer(new HeapNode(matrix[row][col], row, col));
        }
        return heap.poll().val;
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

    class HeapComparator implements Comparator<HeapNode> {
        @Override
        public int compare(HeapNode a, HeapNode b) {
            return a.val - b.val;
        }
    }


    /**
     * Time O(n * log(max - min))
     * Space O(1)
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            int count = countLess(matrix, mid);
            if(count >= k) right = mid;
            else left = mid;
        }
        if(countLess(matrix, right) <= k - 1) return right;
        return left;
    }

    private int countLess(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int i = n - 1, j = 0;
        while(i >= 0 && j < n) {
            if(matrix[i][j] < target) {
                count += i + 1;
                j++;
            } else i--;
        }
        return count;
    }

}
