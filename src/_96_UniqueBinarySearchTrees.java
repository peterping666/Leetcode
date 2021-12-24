import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class _96_UniqueBinarySearchTrees {

    /**
     * Also apply to question: n does, how many structures of binary tree
     */
    class Solution1 {
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }

    class Solution2 {
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - j - 1];
                }
            }
            return dp[n];
        }
    }

    class Solution3 {
        public int numTrees(int n) {
            return helper(1, n, new HashMap<>());
        }

        private int helper(int left, int right, Map<Pair<Integer, Integer>, Integer> map) {
            if(left >= right) {
                return 1;
            }
            Pair<Integer, Integer> pair = new Pair(left, right);
            if(map.containsKey(pair)) {
                return map.get(pair);
            }
            int res = 0;
            for(int i = left; i <= right; i++) {
                res += helper(left, i-1, map) * helper(i+1, right, map);
            }
            map.put(pair, res);
            return res;
        }
    }
}
