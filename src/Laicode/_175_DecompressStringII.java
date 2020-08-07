package Laicode;

public class _175_DecompressStringII {
    public class Solution {
        public String decompress(String input) {
            StringBuilder sb = new StringBuilder();
            char[] array = input.toCharArray();
            for(int i = 0; i < input.length(); i++) {
                char ch = array[i++];
                int count = array[i] - '0';
                for(int c = 0; c < count; c++) {
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }

}
