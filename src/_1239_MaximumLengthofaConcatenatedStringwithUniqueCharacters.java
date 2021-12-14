import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1239_MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    class Solution {
        public int maxLength(List<String> arr) {
            int[] res = new int[1];
            helper(arr, res, "", 0);
            return res[0];
        }

        private void helper(List<String> arr, int[] res, String cur, int index) {
            if(!valid(cur)) {
                return;
            }
            res[0] = Math.max(res[0], cur.length());
            for(int i = index; i < arr.size(); i++) {
                helper(arr, res, cur + arr.get(i), i + 1);
            }
        }

        private boolean valid(String str) {
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(!set.add(c)) {
                    return false;
                }
            }
            return true;
        }
    }
}
