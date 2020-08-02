package Laicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _65_AllPermutationsII {
    public class Solution {
        public List<String> permutations(String input) {
            List<String> res = new ArrayList<>();
            dfs(res, input.toCharArray(), 0);
            return res;
        }

        private void dfs(List<String> res, char[] input, int index) {
            if(index == input.length) {
                res.add(new String(input));
            }
            Set<Character> used = new HashSet<>();
            for(int i = index; i < input.length; i++) {
                if(used.add(input[i])) {
                    swap(input, index, i);
                    dfs(res, input, index + 1);
                    swap(input, index, i);
                }
            }
        }

        private void swap(char[] chars, int l, int r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
        }
    }

}
