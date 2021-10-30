public class _408_ValidWordAbbreviation {
    class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            int index = 0;
            for(int i = 0; i < abbr.length(); i++) {
                char c = abbr.charAt(i);
                if(Character.isDigit(c)) {
                    int num = c - '0';
                    if(num == 0) {
                        return false;
                    }
                    while(i + 1 < abbr.length() && Character.isDigit(abbr.charAt(i + 1))) {
                        num = num * 10 + abbr.charAt(i + 1) - '0';
                        i++;
                    }
                    index += num;
                } else if(index >= word.length() || c != word.charAt(index++)) {
                    return false;
                }
            }
            return index == word.length();
        }
    }
}
