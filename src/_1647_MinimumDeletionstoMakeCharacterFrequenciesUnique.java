import java.util.HashSet;
import java.util.Set;

public class _1647_MinimumDeletionstoMakeCharacterFrequenciesUnique {
    class Solution {
        public int minDeletions(String s) {
            int[] arr = new int[26];
            int res = 0;
            for (char ch : s.toCharArray()) {
                arr[ch - 'a']++;
            }
            Set<Integer> used = new HashSet<>();
            for (int i = 0; i < 26; i++) {
                int freq = arr[i];
                while (freq > 0) {
                    if (used.add(freq)) {
                        break;
                    }
                    freq--;
                    res++;
                }
            }
            return res;
        }
    }
}
