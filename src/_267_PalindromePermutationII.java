import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _267_PalindromePermutationII {
    /**
     * Time O()
     * Space O(n)
     * @param s
     * @return
     */
    public List<String> generatePalindromes(String s) {
        List<String> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int oddCount = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) % 2 == 1) {
                oddCount++;
            } else {
                oddCount--;
            }
        }
        if(oddCount > 1) return list;
        String mid = "";
        List<Character> chars = new ArrayList<>();
        for(Character key : map.keySet()) {
            if(map.get(key) % 2 == 1) {
                mid += key;
            }
            for(int i = 0; i < map.get(key) / 2; i++) {
                chars.add(key);
            }
        }
        helper(list, new StringBuilder(), mid, chars, new boolean[chars.size()]);
        return list;
    }

    private void helper(List<String> list, StringBuilder sb, String mid,
                        List<Character> chars, boolean[] used) {
        if(sb.length() == chars.size()) {
            list.add(sb.toString() + mid + sb.reverse());
            sb.reverse();
            return;
        }
        for(int i = 0; i < chars.size(); i++) {
            if(used[i] || (i != 0 && !used[i-1] && chars.get(i) == chars.get(i-1))) continue;
            sb.append(chars.get(i));
            used[i] = true;
            helper(list, sb, mid, chars, used);
            used[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }
}
