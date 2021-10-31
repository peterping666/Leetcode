import java.util.Random;

public class _528_RandomPickwithWeight {
    class Solution {

        int[] prefixSum;
        int sum;
        Random random;
        public Solution(int[] w) {
            random = new Random();
            sum = 0;
            prefixSum = new int[w.length];
            for(int i = 0; i < w.length; i++) {
                sum += w[i];
                prefixSum[i] = sum;
            }
        }

        public int pickIndex() {
            int target = random.nextInt(sum) + 1;
            int left = 0;
            int right = prefixSum.length - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(prefixSum[mid] == target) {
                    return mid;
                } else if(target < prefixSum[mid]){
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
