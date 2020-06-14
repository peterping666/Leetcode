import java.util.HashMap;

public class _383_RansomNote {
    /**
     * Time O(n)
     * Space O(n)
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++) {
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }
        for(int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        return map.size() == 0;
    }
}
