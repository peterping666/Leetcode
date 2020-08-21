public class _415_AddStrings {
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int idx1 = num1.length() - 1;
            int idx2 = num2.length() - 1;
            int val = 0;
            while(idx1 >= 0 || idx2 >= 0) {
                if(idx1 >= 0) {
                    val += num1.charAt(idx1) - '0';
                    idx1--;
                }
                if(idx2 >= 0) {
                    val += num2.charAt(idx2) - '0';
                    idx2--;
                }
                sb.append(val % 10);
                val /= 10;
            }
            if(val != 0) {
                sb.append(val);
            }
            return sb.reverse().toString();
        }
    }
}
