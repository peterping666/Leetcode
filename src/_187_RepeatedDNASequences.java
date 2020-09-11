import java.util.*;

public class _187_RepeatedDNASequences {
    /**
     * Time O(10 * n)
     * Space O(n)
     */
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            if(s.length() <= 10) {
                return new ArrayList<>();
            }
            HashMap<Character, Integer> map = new HashMap();
            map.put('A', 0);
            map.put('C', 1);
            map.put('G', 2);
            map.put('T', 3);
            int power = (int)Math.pow(4, 10);
            HashSet<Integer> set = new HashSet<>();
            HashSet<String> output = new HashSet<>();
            int hashCode = 0;
            for(int i = 0; i < 10; i++) {
                hashCode = hashCode * 4 + map.get(s.charAt(i));
            }
            set.add(hashCode);
            for(int i = 1; i < s.length() - 9; i++) {
                hashCode = hashCode * 4 + map.get(s.charAt(i + 9))
                        - power * map.get(s.charAt(i - 1));
                if(!set.add(hashCode)) {
                    output.add(s.substring(i, i + 10));
                }
            }
            return new ArrayList<>(output);
        }
    }
}
