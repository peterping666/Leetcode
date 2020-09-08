package Laicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _650_CommonNumbersOfTwoArraysIArrayversion {
    public class Solution1 {
        public List<Integer> common(int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);
            int indexA = 0;
            int indexB = 0;
            List<Integer> res = new ArrayList<>();
            while(indexA < a.length && indexB < b.length) {
                if(a[indexA] == b[indexB]) {
                    res.add(a[indexA]);
                    indexA++;
                    indexB++;
                } else if(a[indexA] < b[indexB]) {
                    indexA++;
                } else {
                    indexB++;
                }
            }
            return res;
        }
    }

}
