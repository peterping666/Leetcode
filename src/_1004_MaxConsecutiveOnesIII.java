public class _1004_MaxConsecutiveOnesIII {
    class Solution {
        public int longestOnes(int[] A, int K) {
            int res = 0;
            int count = 0;
            for(int i = 0, j = 0; i < A.length; i++) {
                if(A[i] == 0) {
                    count++;
                }
                while(count > K) {
                    if(A[j] == 0) {
                        count--;
                    }
                    j++;
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }
}
