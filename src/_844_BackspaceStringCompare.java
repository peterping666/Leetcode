public class _844_BackspaceStringCompare {
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            int m = s.length(), n = t.length(), i = m-1, j = n-1;
            while(i >= 0 || j >= 0) {
                int back = 0;
                while(i >= 0 && (back > 0 || s.charAt(i) == '#')) {
                    back += s.charAt(i) == '#' ? 1 : -1;
                    i--;
                }
                back = 0;
                while(j >= 0 && (back > 0 || t.charAt(j) == '#')) {
                    back += t.charAt(j) == '#' ? 1 : -1;
                    j--;
                }

                if(i < 0 && j >= 0 || j < 0 && i >= 0 || i >= 0 && j >= 0 &&
                        s.charAt(i) != t.charAt(j)) {
                    return false;
                }
                i--;
                j--;
            }
            return true;
        }
    }
}
