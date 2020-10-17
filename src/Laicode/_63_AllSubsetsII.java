package Laicode;

import java.util.*;

public class _63_AllSubsetsII {
    public class Solution1 {
        public List<String> subSets(String set) {
            List<String> result = new ArrayList<>();
            // corner case
            if(set == null) {
                return result;
            }
            Map<Character, Integer> map = new HashMap<>();
            List<Character> list = new ArrayList<>();
            for(int i = 0; i < set.length(); i++) {
                char c = set.charAt(i);
                if(!map.containsKey(c)) {
                    list.add(c);
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
            Collections.sort(list);
            helper(map, list, new StringBuilder(), result, 0);
            return result;
        }

        private void helper(Map<Character, Integer> map, List<Character> list, StringBuilder sb,
                            List<String> result, int index) {
            if(index == list.size()) {
                result.add(sb.toString());
                return;
            }
            for(int i = 0; i <= map.get(list.get(index)); i++) {
                for(int j = 0; j < i; j++) {
                    sb.append(list.get(index));
                }
                helper(map, list, sb, result, index + 1);
                for(int j = 0; j < i; j++) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public class Solution2 {
        public List<String> subSets(String set) {
            List<String> result = new ArrayList<>();
            // corner case
            if(set == null) {
                return result;
            }
            char[] charSet = set.toCharArray();
            Arrays.sort(charSet);
            helper(charSet, new StringBuilder(), result, 0);
            return result;
        }

        private void helper(char[] charSet, StringBuilder sb, List<String> result, int index) {
            result.add(sb.toString());
            for(int i = index; i < charSet.length; i++) {
                if(i == index || charSet[i] != charSet[i - 1]) {
                    sb.append(charSet[i]);
                    helper(charSet, sb, result, i + 1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
