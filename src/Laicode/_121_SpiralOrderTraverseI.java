package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _121_SpiralOrderTraverseI {
    public class Solution1 {
        public List<Integer> spiral(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            spiral(matrix, 0, matrix.length, res);
            return res;
        }

        private void spiral(int[][] matrix, int offset, int size, List<Integer> res) {
            if(size == 0) {
                return;
            }
            if(size == 1) {
                res.add(matrix[offset][offset]);
                return;
            }

            // up bound
            for(int i = 0; i < size - 1; i++) {
                res.add(matrix[offset][i + offset]);
            }
            // right side
            for(int i = 0; i < size - 1; i++) {
                res.add(matrix[i + offset][offset + size - 1]);
            }
            // bottom bound
            for(int i = size - 1; i > 0; i--) {
                res.add(matrix[offset + size - 1][i + offset]);
            }
            // left side
            for(int i = size - 1; i > 0; i--) {
                res.add(matrix[offset + i][offset]);
            }
            spiral(matrix, offset + 1, size - 2, res);
        }
    }

    public class Solution2 {
        public List<Integer> spiral(int[][] matrix) {
            List<Integer> list = new ArrayList<>();
            int n = matrix.length;
            int start = 0;
            int end = n - 1;
            while(start < end) {
                for(int i = start; i < end; i++) {
                    list.add(matrix[start][i]);
                }
                for(int i = start; i < end; i++) {
                    list.add(matrix[i][end]);
                }
                for(int i = end; i > start; i--) {
                    list.add(matrix[end][i]);
                }
                for(int i = end; i > start; i--) {
                    list.add(matrix[i][start]);
                }
                start++;
                end--;
            }
            if(start == end) {
                list.add(matrix[start][end]);
            }
            return list;
        }
    }


}
