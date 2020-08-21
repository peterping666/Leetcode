import java.util.PriorityQueue;
import java.util.Queue;

public class _973_KClosestPointstoOrigin {
    /**
     * Time: O(nlogk)
     * Space O(n)
     */
    class Solution1 {
        public int[][] kClosest(int[][] points, int K) {
            Queue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
                    Integer.compare((b[0] * b[0] + b[1] * b[1]), a[0] * a[0] + a[1] * a[1]));

            for(int[] point : points) {
                maxHeap.offer(point);
                if(maxHeap.size() > K) {
                    maxHeap.poll();
                }
            }
            int[][] res = new int[K][2];
            for(int i = 0; i < K; i++) {
                res[i] = maxHeap.poll();
            }
            return res;
        }
    }

    class Solution2 {
        public int[][] kClosest(int[][] points, int K) {
            quickSelect(points, K, 0, points.length - 1);
            int[][] res = new int[K][2];
            for(int i = 0; i < K; i++) {
                res[i] = points[i];
            }
            return res;
        }

        private void quickSelect(int[][] points, int K, int left, int right) {
            if(left >= right) {
                return;
            }
            int pivotIndex = partition(points, left, right);
            if(pivotIndex == K) {
                return;
            }
            if(pivotIndex < K) {
                quickSelect(points, K, pivotIndex + 1, right);
            } else {
                quickSelect(points, K, left, pivotIndex - 1);
            }
        }

        private int partition(int[][] points, int left, int right) {
            int[] pivot = points[right];
            int leftBound = left;
            int rightBound = right - 1;
            while(leftBound <= rightBound) {
                if(dist(points[leftBound]) <= dist(pivot)) {
                    leftBound++;
                } else if(dist(points[rightBound]) > dist(pivot)) {
                    rightBound--;
                } else {
                    swap(points, leftBound++, rightBound--);
                }
            }
            swap(points, leftBound, right);
            return leftBound;
        }

        private int dist(int[] point) {
            return point[0] * point[0] + point[1] * point[1];
        }

        private void swap(int[][] points, int left, int right) {
            int[] tmp = points[left];
            points[left] = points[right];
            points[right] = tmp;
        }
    }
}
