import java.util.Arrays;

public class _174_DungeonGame {
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            int[] dp = new int[n+1];
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[n-1] = 0;

            for(int i = m-1; i >= 0; i--){
                for(int j = n-1; j >= 0; j--){

                    int res = Math.max(dp[j], dp[j+1]);

                    if( res > 0 && dungeon[i][j] < 0 ) {
                        dp[j] = dungeon[i][j];
                    }
                    else{
                        dp[j] = dungeon[i][j] + res;
                    }
                }
            }
            if( dp[0] > 0) return 1;
            return 1 - dp[0];
        }
    }
}
