import java.util.*;

public class _187_RepeatedDNASequences {

    class Solutio1 {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> res = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i <= s.length() - 10; i++) {
                String cur = s.substring(i, i+10);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                if(map.get(cur) == 2) {
                    res.add(cur);
                }
            }
            return res;
        }
    }

    class Solution2 {
        public List<String> findRepeatedDnaSequences(String s) {
            HashMap<Character, Integer> map = new HashMap();
            map.put('A', 1);
            map.put('C', 2);
            map.put('G', 3);
            map.put('T', 4);
            Map<Integer, Integer> count = new HashMap<>();
            List<String> res = new ArrayList<>();
            int hashCode = 0, power = (int)Math.pow(4, 10);;
            for(int i = 0, j = 0; i < s.length(); i++) {
                hashCode = hashCode * 4 + map.get(s.charAt(i));
                if(i - j + 1 > 10) {
                    hashCode = hashCode - power * map.get(s.charAt(j++));
                }
                if(i - j + 1 == 10) {
                    count.put(hashCode, count.getOrDefault(hashCode, 0) + 1);
                    if(count.get(hashCode) == 2) {
                        res.add(s.substring(j, i+1));
                    }
                }
            }
            return res;
        }
    }
}
