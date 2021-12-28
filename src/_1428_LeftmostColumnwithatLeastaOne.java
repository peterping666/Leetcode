import java.util.ArrayList;
import java.util.List;

public class _1428_LeftmostColumnwithatLeastaOne {

    /**
     * Time O(m + n)
     */
    class Solution1 {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            List<Integer> list = binaryMatrix.dimensions();
            int m = list.get(0), n = list.get(1);
            int i = 0, j = n-1, res = -1;
            while(i < m && j >= 0) {
                if(binaryMatrix.get(i, j) == 1) {
                    res = j;
                    j--;
                } else {
                    i++;
                }
            }
            return res;
        }
    }

    /**
     * Time O(mlogn)
     */
    class Solution2 {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            List<Integer> list = binaryMatrix.dimensions();
            int m = list.get(0), n = list.get(1);
            int res = n;
            for (int i = 0; i < m; i++) {
                int index = leftMost(i, n, binaryMatrix);
                if(index != -1) {
                    res = Math.min(res, index);
                }
            }
            return res == n ? -1 : res;
        }

        private int leftMost(int i, int n, BinaryMatrix bm) {
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int val = bm.get(i, mid);
                if (val == 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return bm.get(i, left) == 1 ? left : -1;
        }
    }

    class BinaryMatrix {
        public int get(int row, int col) {return 1;}
        public List<Integer> dimensions() {
            return new ArrayList<>();}
    }
}


