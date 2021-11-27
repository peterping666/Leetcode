public class _935_KnightDialer {
    class Solution {

        public int knightDialer(int n) {
            int[][][] memo = new int[n + 1][4][3];
            int res = 0;
            int mod = (int) (1e9+7);
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 3; j++) {
                    res = (res + helper(n, memo, i, j, mod)) % mod;
                }
            }
            return res;
        }

        private int helper(int n, int[][][] memo, int i, int j, int mod) {
            if(i < 0 || i >= 4 || j < 0 || j >= 3 || i == 3 && j != 1) {
                return 0;
            }
            if(n == 1) {
                return 1;
            }
            if(memo[n][i][j] != 0) {
                return memo[n][i][j];
            }
            int[][] dirs = {{1, 2}, {1, -2}, {2,1}, {2,-1}, {-1,2}, {-1,-2}, {-2,1}, {-2,-1}};
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                memo[n][i][j] = (memo[n][i][j] + helper(n - 1, memo, x, y, mod)) % mod;
            }
            return memo[n][i][j];
        }
    }
}
