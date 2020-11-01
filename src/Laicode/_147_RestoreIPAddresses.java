package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _147_RestoreIPAddresses {
    public class Solution {
        public List<String> Restore(String ip) {
            List<String> res = new ArrayList<>();
            backtracking(ip, res, new StringBuilder(), 0, 0);
            return res;
        }

        private void backtracking(String ip, List<String> res, StringBuilder sb, int dots, int index) {
            if(dots > 4) {
                return;
            }
            if(dots == 4 && index == ip.length()) {
                res.add(sb.substring(0, sb.length() - 1));
                return;
            }
            for(int i = 1; i < 4; i++) {
                if(index + i > ip.length()) {
                    return;
                }
                String str = ip.substring(index, index + i);
                if(str.startsWith("0") && str.length() > 1 || i == 3 && Integer.parseInt(str) > 255) {
                    return;
                }
                int from = sb.length();
                sb.append(str).append('.');
                backtracking(ip, res, sb, dots + 1, index + i);
                sb.delete(from, sb.length());
            }
        }
    }

}
