package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _652_CommonNumbersOfTwoSortedArrays {
    public class Solution {
        public List<Integer> common(int[] A, int[] B) {
            int i = 0;
            int j = 0;
            List<Integer> res = new ArrayList<>();
            while(i < A.length && j < B.length) {
                if(A[i] < B[j]) {
                    i++;
                } else if(A[i] > B[j]) {
                    j++;
                } else {
                    res.add(A[i]);
                    i++;
                    j++;
                }
            }
            return res;
        }
    }

}
