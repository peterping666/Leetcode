import java.util.*;

public class _49_GroupAnagrams {
    /**
     * Time O(N * 26)
     * Space O(N * L)
     */
    class Solution1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for(String str : strs) {
                int[] count = new int[26];
                for(int i = 0; i < str.length(); i++) {
                    count[str.charAt(i) - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for(int num : count) {
                    sb.append('#');
                    sb.append(num);
                }
                String key = sb.toString();
                if(!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }


    /**
     * Time O(N * LlogL)
     * Space O(N * L)
     * @return
     */
    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for(String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String sortedStr = new String(chars);
                map.putIfAbsent(sortedStr, new ArrayList<>());
                map.get(sortedStr).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
}
