public class _67_AddBinary {
    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int aIndex = a.length() - 1;
            int bIndex = b.length() - 1;
            int num = 0;
            while(aIndex >= 0 || bIndex >= 0) {
                if(aIndex >= 0) {
                    num += a.charAt(aIndex) - '0';
                    aIndex--;
                }
                if(bIndex >= 0) {
                    num += b.charAt(bIndex) - '0';
                    bIndex--;
                }
                sb.append(num % 2);
                num /= 2;
            }
            if(num != 0) {
                sb.append(num);
            }
            return sb.reverse().toString();
        }
    }
}
