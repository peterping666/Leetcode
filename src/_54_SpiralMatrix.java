import java.util.ArrayList;
import java.util.List;

public class _54_SpiralMatrix {
    class Solution1 {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if(matrix.length == 0 || matrix[0].length == 0) {
                return res;
            }
            int up = 0;
            int down = matrix.length - 1;
            int left = 0;
            int right = matrix[0].length - 1;
            while(up < down && left < right) {
                for(int i = left; i < right; i++) {
                    res.add(matrix[up][i]);
                }
                for(int i = up; i < down; i++) {
                    res.add(matrix[i][right]);
                }
                for(int i = right; i > left; i--) {
                    res.add(matrix[down][i]);
                }
                for(int i = down; i > up; i--) {
                    res.add(matrix[i][left]);
                }
                up++;
                down--;
                left++;
                right--;
            }
            if(left > right || up > down) {
                return res;
            }
            if(left == right) {
                for(int i = up; i <= down; i++) {
                    res.add(matrix[i][left]);
                }
            } else {
                for(int i = left; i <= right; i++) {
                    res.add(matrix[up][i]);
                }
            }
            return res;
        }
    }

    class Solution2 {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if(matrix.length == 0 || matrix[0].length == 0) {
                return res;
            }
            int up = 0;
            int down = matrix.length - 1;
            int left = 0;
            int right = matrix[0].length - 1;
            while(up <= down && left <= right) {
                for(int i = left; i <= right; i++) {
                    res.add(matrix[up][i]);
                }
                up++;

                for(int i = up; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                right--;

                if(up <= down) {
                    for(int i = right; i >= left; i--) {
                        res.add(matrix[down][i]);
                    }
                    down--;
                }

                if(left <= right) {
                    for(int i = down; i >= up; i--) {
                        res.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            return res;
        }
    }
}
