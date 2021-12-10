import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _205_IsomorphicStrings {

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if(s.length() != t.length()) {
                return false;
            }
            Map<Character, Character> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < s.length(); i++) {
                char key = s.charAt(i);
                char val = t.charAt(i);
                if(map.containsKey(key)) {
                    if(map.get(key) != val) {
                        return false;
                    }
                } else {
                    if(set.contains(val)) {
                        return false;
                    }
                    map.put(key, val);
                    set.add(val);
                }
            }
            return true;
        }
    }
}
