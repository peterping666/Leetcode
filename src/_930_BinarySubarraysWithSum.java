public class _930_BinarySubarraysWithSum {
    class Solution {
        public int numSubarraysWithSum(int[] A, int S) {
            int[] count = new int[A.length + 1];
            count[0] = 1;
            int res = 0;
            int sum = 0;
            for(int a : A) {
                sum += a;
                if(sum >= S) {
                    res += count[sum - S];
                }
                count[sum]++;
            }
            return res;
        }
    }
}
