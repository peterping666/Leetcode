import java.util.HashMap;

public class _76_MinimumWindowSubstring {
    /**
     * Time O(n)
     * Space O(n)
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = t.length();
        int len = Integer.MAX_VALUE;
        int from = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c) >= 0) {
                    count--;
                }
            }
            while(count == 0) {
                if(len > i - j + 1) {
                    len = i - j + 1;
                    from = j;
                }
                char d = s.charAt(j++);
                if(!map.containsKey(d)) continue;
                map.put(d, map.get(d) + 1);
                if(map.get(d) > 0) count++;

            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(from, from + len);
    }

    /**
     * Time O(n)
     * Space O(128)
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        int[] freq = new int[128];
        for(int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }
        int count = t.length();
        int len = Integer.MAX_VALUE;
        int from = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            if(freq[s.charAt(i)]-- > 0) count--;
            while(count == 0) {
                if(len > i - j + 1) {
                    len = i - j + 1;
                    from = j;
                }
                if(++freq[s.charAt(j++)] > 0) count++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(from, from + len);
    }
}
