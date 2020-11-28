import java.util.*;

public class _451_SortCharactersByFrequency {
    /**
     * Time O(n)
     * Sapce O(n)
     */
    class Solution {
        public String frequencySort(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            List<Character>[] array = new List[s.length() + 1];
            for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                int index = entry.getValue();
                if(array[index] == null) {
                    array[index] = new ArrayList<>();
                }
                array[index].add(entry.getKey());
            }
            StringBuilder sb = new StringBuilder();
            for(int i = array.length - 1; i >= 0; i--) {
                List<Character> list = array[i];
                if(list != null) {
                    for(char c : list) {
                        for(int j = 0; j < i; j++) {
                            sb.append(c);
                        }
                    }
                }
            }
            return sb.toString();
        }
    }

    /**
     * Time O(nlogn)
     * Space O(n)
     */
    class Solution2 {
        public String frequencySort(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
            Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<Character,Integer> entry : list) {
                for(int j = 0; j < entry.getValue(); j++) {
                    sb.append(entry.getKey());
                }
            }
            return sb.toString();
        }
    }
}
