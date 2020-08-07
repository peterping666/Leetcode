package Laicode;

public class _611_CompressStringII {
    public class Solution {
        public String compress(String input) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                int count = 1;
                while(i + 1 < input.length() && input.charAt(i + 1) == c) {
                    i++;
                    count++;
                }
                sb.append(c).append(count);
            }
            return sb.toString();
        }
    }

}
