import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _266_PalindromePermutation {
    /**
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome1(String s) {
        HashMap< Character, Integer > map = new HashMap < > ();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (char key: map.keySet()) {
            count += map.get(key) % 2;
        }
        return count <= 1;
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome2(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome3(String s) {
        Set< Character > set = new HashSet< >();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }
}
