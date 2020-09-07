public class _935_KnightDialer {
    class Solution {
        private final int max = (int) Math.pow(10, 9) + 7;

        public int knightDialer(int N) {
            long[][][] memo = new long[N + 1][4][3];
            long res = 0;
            int[][] dirs = {{1, 2}, {1, -2}, {2,1}, {2,-1}, {-1,2}, {-1,-2}, {-2,1}, {-2,-1}};
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 3; j++) {
                    res = (res + helper(N, memo, i, j, dirs)) % max;
                }
            }
            return (int)res;
        }

        private long helper(int n, long[][][] memo, int i, int j, int[][] dirs) {
            if(i < 0 || i >= 4 || j < 0 || j >= 3 || i == 3 && j != 1) {
                return 0;
            }
            if(n == 1) {
                return 1;
            }
            if(memo[n][i][j] != 0) {
                return memo[n][i][j];
            }
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                memo[n][i][j] = (memo[n][i][j] + helper(n - 1, memo, x, y, dirs)) % max;
            }
            return memo[n][i][j];
        }
    }
}
