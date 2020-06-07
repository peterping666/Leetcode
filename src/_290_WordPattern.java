import java.util.HashMap;
import java.util.HashSet;

public class _290_WordPattern {
    /**
     * Time O(n)
     * Space O(1) / O(n)
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)) {
                if(!map.get(c).equals(strs[i])) return false;
            } else {
                if(set.contains(strs[i])) return false;
                map.put(c, strs[i]);
                set.add(strs[i]);
            }
        }
        return true;
    }
}
