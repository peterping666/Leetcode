import java.util.Arrays;

public class _646_MaximumLengthofPairChain {
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
            int res = 1, right = pairs[0][1];
            for(int i = 1; i < pairs.length; i++) {
                if(pairs[i][0] > right) {
                    res++;
                    right = pairs[i][1];
                }
            }
            return res;
        }
    }
}
