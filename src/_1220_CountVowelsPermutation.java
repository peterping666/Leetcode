import java.util.Arrays;

public class _1220_CountVowelsPermutation {
    class Solution1 {
        public int countVowelPermutation(int n) {
            int MOD = (int) (1e9 + 7);
            long[][] dp = new long[n + 1][5];
            for (int i = 0; i < 5; i++) {
                dp[1][i] = 1;
            }
        /*
            0: a
            1: e
            2: i
            3: o
            4: u
         */
            for (int i = 1; i < n; i++) {
                dp[i+1][0] = (dp[i][4] + dp[i][1] + dp[i][2]) % MOD;
                dp[i+1][1] = (dp[i][0] + dp[i][2]) % MOD;
                dp[i+1][2] = (dp[i][3] + dp[i][1]) % MOD;
                dp[i+1][3] = (dp[i][2]) % MOD;
                dp[i+1][4] = (dp[i][2] + dp[i][3]) % MOD;
            }

            long ans = 0;
            for (int i = 0; i < 5; i++)
                ans = (ans + dp[n][i]) % MOD;
            return (int) ans;
        }
    }

    class Solution2 {
        public int countVowelPermutation(int n) {
            int[] cur = new int[5], next = new int[5];
            Arrays.fill(cur, 1);
            int mod = 1_000_000_007;
            for (int i = 1; i < n; ++i) {
                next[0] = cur[1];
                next[1] = (cur[0] + cur[2]) % mod;
                next[2] = (((cur[0] + cur[1]) % mod + cur[3]) % mod + cur[4]) % mod;
                next[3] = (cur[2] + cur[4]) % mod;
                next[4] = cur[0];
                int[] tmp = cur;
                cur = next;
                next = tmp;
            }
            int res = 0;
            for (int c : cur) res = (res + c) % mod;
            return res;
        }
    }
}
