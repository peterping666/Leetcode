import java.util.HashSet;
import java.util.Set;

public class _1525_NumberofGoodWaystoSplitaString {
    class Solution {
        public int numSplits(String s) {
            int n = s.length();
            int[] left = new int[n], right = new int[n];
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < n; i++) {
                set.add(s.charAt(i));
                left[i] = set.size();
            }
            set.clear();
            for(int i = n-1; i >= 0; i--) {
                set.add(s.charAt(i));
                right[i] = set.size();
            }
            int res = 0;
            for(int i = 0; i < n-1; i++) {
                res += left[i] == right[i+1] ? 1 : 0;
            }
            return res;
        }
    }
}
