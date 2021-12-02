public class _8_StringtoIntegeratoi {
    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution {
        public int myAtoi(String s) {
            s = s.trim();
            if(s.length() == 0) {
                return 0;
            }
            char firstChar = s.charAt(0);
            int sign = 1, start = 0;
            if(firstChar == '+') {
                start++;
            }else if(firstChar == '-') {
                sign = -1;
                start++;
            }
            long res = 0;
            for(int i = start; i < s.length(); i++) {
                if(!Character.isDigit(s.charAt(i))) {
                    return (int)res * sign;
                }
                res = res * 10 + s.charAt(i) - '0';
                if(sign == 1 && res >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if(sign == -1 && res > Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            return (int)res * sign;
        }
    }
}
