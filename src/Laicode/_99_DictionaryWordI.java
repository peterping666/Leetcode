package Laicode;

import java.util.HashSet;
import java.util.Set;

public class _99_DictionaryWordI {
    public class Solution {
        public boolean canBreak(String input, String[] dict) {
            boolean[] dp = new boolean[input.length() + 1];
            Set<String> dictSet = toSet(dict);
            dp[0] = true;
            for(int i = 1; i < dp.length; i++) {
                for(int j = 0; j < i; j++) {
                    if(dp[j] && dictSet.contains(input.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[input.length()];
        }

        private Set<String> toSet(String[] dict) {
            Set<String> set = new HashSet<>();
            for(String str : dict) {
                set.add(str);
            }
            return set;
        }
    }
}
