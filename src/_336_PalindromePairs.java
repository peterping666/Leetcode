import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _336_PalindromePairs {
    /**
     * Time O(n * k^2)
     * Space O(n)
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> lists = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            for(int j = 0; j <= word.length(); j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);
                if(isPalindrome(prefix)) {
                    String wordRev = new StringBuilder(suffix).reverse().toString();
                    if(map.containsKey(wordRev) && map.get(wordRev) != i) {
                        lists.add(Arrays.asList(map.get(wordRev), i));
                    }
                }
                if(suffix.length() != 0 && isPalindrome(suffix)) {
                    String wordRev = new StringBuilder(prefix).reverse().toString();
                    if(map.containsKey(wordRev) && map.get(wordRev) != i) {
                        lists.add(Arrays.asList(i, map.get(wordRev)));
                    }
                }
            }
        }
        return lists;
    }

    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while(l < r) {
            if(str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
