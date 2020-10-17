package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _640_AllSubsetsofSizeK {
    public class Solution {
        public List<String> subSetsOfSizeK(String set, int k) {
            List<String> result = new ArrayList<>();
            helper(set, result, new StringBuilder(), k, 0);
            return result;
        }

        private void helper(String set, List<String> result, StringBuilder sb, int size, int index) {
            if(sb.length() == size) {
                result.add(sb.toString());
                return;
            }
            if(index == set.length()) {
                return;
            }
            helper(set, result, sb.append(set.charAt(index)), size, index + 1);
            sb.deleteCharAt(sb.length() - 1);
            helper(set, result, sb, size, index + 1);
        }
    }

}
