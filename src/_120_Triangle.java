import java.util.List;

public class _120_Triangle {
    /**
     * Time O(n^2)
     * Space O(n^2)
     */
    class Solution1 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int m = triangle.size();
            int[][] dp = new int[m + 1][m + 1];
            for(int i = m - 1; i >= 0; i--) {
                for(int j = 0; j < triangle.get(i).size(); j++) {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
                }
            }
            return dp[0][0];
        }
    }
    /**
     * Time O(n^2)
     * Space O(n)
     * @return
     */
    class Solution2 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] sums = new int[n + 1];
            for(int i = n - 1; i >= 0; i--) {
                for(int j = 0; j < triangle.get(i).size(); j++) {
                    sums[j] = Math.min(sums[j], sums[j + 1]) + triangle.get(i).get(j);
                }
            }
            return sums[0];
        }
    }
}
