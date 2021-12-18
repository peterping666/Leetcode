import java.util.*;

public class _451_SortCharactersByFrequency {

    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution1 {
        public String frequencySort(String s) {
            int n = s.length();
            int[] freq = new int[128];
            for(int i = 0; i < n; i++) {
                freq[s.charAt(i)]++;
            }
            List<Character>[] bucket = new List[n+1];
            for(int i = 0; i < freq.length; i++) {
                if(freq[i] > 0) {
                    if(bucket[freq[i]] == null) {
                        bucket[freq[i]] = new ArrayList<>();
                    }
                    bucket[freq[i]].add((char)i);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = n; i > 0; i--) {
                if(bucket[i] != null) {
                    List<Character> list = bucket[i];
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
     * Time O(n)
     * Sapce O(n)
     */
    class Solution2 {
        public String frequencySort(String s) {
            int n = s.length();
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            List<Character>[] bucket = new List[n + 1];
            for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                int index = entry.getValue();
                if(bucket[index] == null) {
                    bucket[index] = new ArrayList<>();
                }
                bucket[index].add(entry.getKey());
            }
            StringBuilder sb = new StringBuilder();
            for(int i = bucket.length - 1; i >= 0; i--) {
                List<Character> list = bucket[i];
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
     * Time O(nlogk)
     * Space O(n)
     */
    class Solution3 {
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
