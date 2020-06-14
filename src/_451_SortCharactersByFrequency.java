import java.util.*;

public class _451_SortCharactersByFrequency {
    /**
     * Time O(nlogn)
     * Space O(n)
     * @param s
     * @return
     */
    public String frequencySort1(String s) {
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

    /**
     * Time O(n)
     * Sapce O(n)
     * @param s
     * @return
     */
    public String frequencySort2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] list = new List[s.length() + 1];
        for(char key : map.keySet()) {
            int index = map.get(key);
            if(list[index] == null) {
                list[index] = new ArrayList<>();
            }
            list[index].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = list.length - 1; i > 0; i--) {
            if(list[i] != null) {
                for(char c : list[i]) {
                    for(int j = 0; j < map.get(c); j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
