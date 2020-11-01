package Laicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _272_CombinationsForTelephonePadI {
    public class Solution {
        public String[] combinations(int number) {
            Map<Integer, String> map = new HashMap<>();
            map.put(0, "");
            map.put(1, "");
            map.put(2, "abc");
            map.put(3, "def");
            map.put(4, "ghi");
            map.put(5, "jkl");
            map.put(6, "mno");
            map.put(7, "pqrs");
            map.put(8, "tuv");
            map.put(9, "wxyz");
            List<String> list = new ArrayList<>();
            backtracking(list, String.valueOf(number), map, new StringBuilder(), 0);
            return list.toArray(new String[0]);
        }

        private void backtracking(List<String> list, String number, Map<Integer, String> map,
                                  StringBuilder sb, int index) {
            if(index == number.length()) {
                list.add(sb.toString());
                return;
            }
            String options = map.get(number.charAt(index) - '0');
            if(options.length() > 0) {
                for(int i = 0; i < options.length(); i++) {
                    sb.append(options.charAt(i));
                    backtracking(list, number, map, sb, index + 1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                backtracking(list, number, map, sb, index + 1);
            }
        }
    }

}
