import java.util.ArrayList;
import java.util.List;

public class _1428_LeftmostColumnwithatLeastaOne {

    // Time: nlogm
    class Solution1 {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            List<Integer> dimension = binaryMatrix.dimensions();
            int row = dimension.get(0);
            int col = dimension.get(1);
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < row; i++) {
                int index = binarySearch(i, col, binaryMatrix);
                if(index != -1) {
                    res = Math.min(res, index);
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }

        private int binarySearch(int row, int col, BinaryMatrix bm) {
            int left = 0;
            int right = col - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                int val = bm.get(row, mid);
                if (val == 1) {
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            return bm.get(row, left) == 1 ? left : -1;
        }
    }

    // Time: m + n
    class Solution2 {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            List<Integer> dimen = binaryMatrix.dimensions();
            int m = dimen.get(0);
            int n = dimen.get(1);
            int ans = -1, r = 0, c = n - 1;
            while (r < m && c >= 0) {
                if (binaryMatrix.get(r, c) == 1) {
                    ans = c;
                    c--;
                } else {
                    r++;
                }
            }
            return ans;
        }
    }

    class BinaryMatrix {
        public int get(int row, int col) {return 1;}
        public List<Integer> dimensions() {
            return new ArrayList<>();}
    }
}


