import java.util.ArrayList;
import java.util.List;

public class _93_RestoreIPAddresses {

    class Solution1 {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            helper(s, res, "", 0, 4);
            return res;
        }

        private void helper(String s, List<String> res, String cur, int start, int count) {
            if(count == 0) {
                if(start == s.length()) {
                    res.add(cur);
                }
                return;
            }

            for(int i = start + 1; i <= Math.min(start + 3, s.length()); i++) {
                if(i > start + 1 && s.charAt(start) == '0') {
                    break;
                }
                String str = s.substring(start, i);
                int num = Integer.valueOf(str);
                if(num <= 255) {
                    helper(s, res, cur + str + (count == 1 ? "" : '.'), i, count - 1);
                }
            }
        }
    }

    /**
     * Time O(3^4 * L)
     */
    class Solution2 {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            helper(s, res, "", 3);
            return res;
        }

        private void helper(String s, List<String> res, String cur, int count) {
            if(count == 0) {
                if(valid(s)) {
                    res.add(cur + s);
                }
                return;
            }
            for(int i = 1; i <= Math.min(3, s.length()); i++) {
                String str = s.substring(0, i);
                if(valid(str)) {
                    helper(s.substring(i), res, cur + str + '.', count - 1);
                }
            }
        }

        private boolean valid(String str) {
            if(str.length() == 0 || str.length() > 3 || str.length() > 1 && str.charAt(0) == '0') {
                return false;
            }
            int num = Integer.valueOf(str);
            return num <= 255;
        }
    }
}
