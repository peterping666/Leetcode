import java.util.ArrayList;
import java.util.List;

public class _93_RestoreIPAddresses {
    /**
     * Time O(3^4)
     * Space O(4)
     * @return
     */
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> list = new ArrayList<>();
            helper(s, list, "", 0, 0);
            return list;
        }

        private void helper(String s, List<String> list, String path, int idx, int count) {
            if(count > 4) return;
            if(count == 4 && idx == s.length()) {
                list.add(path);
                return;
            }

            for(int i = 1; i < 4; i++) {
                if(idx + i > s.length()) {
                    return;
                }
                String str = s.substring(idx, idx + i);
                if(str.startsWith("0") && str.length() > 1 || i == 3 && Integer.parseInt(str) > 255) {
                    return;
                }
                helper(s, list, path + str + (count == 3 ? "" : "."), idx + i, count + 1);
            }
        }
    }
}
