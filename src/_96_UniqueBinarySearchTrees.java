public class _96_UniqueBinarySearchTrees {
    /**
     * Time O(n)
     * Space O(n)
     *
     */
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            // i represents the # of tree nodes in the whole tree
            for(int i = 1; i <= n; i++) {
                // j represents the # of nodes in left subtree
                // i - j - 1 is the # of nodes in right subtree
                for(int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - j - 1];
                }
            }
            return dp[n];
        }
    }
}
