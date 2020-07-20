import java.util.PriorityQueue;

public class _973_KClosestPointstoOrigin {
    class Solution1  {
        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> heap = new PriorityQueue<>(
                    (a, b) -> Integer.compare((int)(Math.pow(b[0], 2) + Math.pow(b[1], 2)),
                            (int) (Math.pow(a[0], 2) + Math.pow(a[1], 2))));

            for(int[] point : points) {
                heap.offer(point);
                if(heap.size() > K) {
                    heap.poll();
                }
            }
            int[][] res = new int[K][2];
            for(int i = 0; i < K; i++) {
                res[i] = heap.poll();
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
