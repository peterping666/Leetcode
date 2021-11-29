public class _678_ValidParenthesisString {
    class Solution {
        public boolean checkValidString(String s) {
            int maxCount = 0; // # of unmatched ( with * as (
            int minCount = 0; // # of unmatched ( with * as ) or ''
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '(') {
                    maxCount++;
                    minCount++;
                } else if(c == ')') {
                    maxCount--;
                    minCount--;
                } else {
                    maxCount++;
                    minCount--;
                }
                if(maxCount < 0) {
                    return false;
                }
                if(minCount < 0) {
                    minCount = 0;
                }
            }
            return minCount == 0;
        }
    }
}
