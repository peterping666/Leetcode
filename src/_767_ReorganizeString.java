public class _767_ReorganizeString {
    /**
     * Time O(n)
     * Space O(26)
     */
    class Solution1 {
        public String reorganizeString(String S) {
            int[] hash = new int[26];
            for (int i = 0; i < S.length(); i++) {
                hash[S.charAt(i) - 'a']++;
            }
            int max = 0, letter = 0;
            for (int i = 0; i < hash.length; i++) {
                if (hash[i] > max) {
                    max = hash[i];
                    letter = i;
                }
            }
            if (max > (S.length() + 1) / 2) {
                return "";
            }
            char[] res = new char[S.length()];
            int idx = 0;
            while (hash[letter] > 0) {
                res[idx] = (char) (letter + 'a');
                idx += 2;
                hash[letter]--;
            }
            for (int i = 0; i < hash.length; i++) {
                while (hash[i] > 0) {
                    if (idx >= res.length) {
                        idx = 1;
                    }
                    res[idx] = (char) (i + 'a');
                    idx += 2;
                    hash[i]--;
                }
            }
            return String.valueOf(res);
        }
    }

    /**
     * Time O(n * 26)
     * Space O(26)
     */
    class Solution2 {
        public String reorganizeString(String S) {
            int[] counts = new int[26];
            int[] index = new int[26];
            for(int i = 0; i < S.length(); i++) {
                counts[S.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < S.length(); i++) {
                int maxCount = 0;
                char c = '#';
                for(int j = 0; j < counts.length; j++) {
                    if(counts[j] > maxCount && index[j] <= i) {
                        maxCount = counts[j];
                        c = (char)(j + 'a');
                    }
                }
                if(c == '#') {
                    return "";
                }
                counts[c - 'a']--;
                index[c - 'a'] += 2;
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
