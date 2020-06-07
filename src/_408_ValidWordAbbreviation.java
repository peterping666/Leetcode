public class _408_ValidWordAbbreviation {
    public boolean validWordAbbreviation1(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param word
     * @param abbr
     * @return
     */
    public boolean validWordAbbreviation2(String word, String abbr) {
        int i = 0, j = 0;
        while(i < word.length() && j < abbr.length()) {
            if(abbr.charAt(j) == '0') {
                return false;
            }
            int len = 0;
            while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                len = len * 10 + abbr.charAt(j) - '0';
                j++;
            }
            if(len != 0) {
                i += len;
            } else if(word.charAt(i) != abbr.charAt(j)) {
                return false;
            } else {
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
