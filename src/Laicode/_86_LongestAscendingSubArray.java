package Laicode;

public class _86_LongestAscendingSubArray {
    public class Solution {
        public int longest(int[] array) {
            if(array.length == 0) {
                return 0;
            }
            int res = 1;
            int dp = 1;
            for(int i = 1; i < array.length; i++) {
                if(array[i] > array[i-1]) {
                    dp++;
                    res = Math.max(res, dp);
                } else {
                    dp = 1;
                }
            }
            return res;
        }
    }

}
