import java.util.ArrayList;
import java.util.List;

public class _763_PartitionLabels {
    class Solution {
        public List<Integer> partitionLabels(String S) {
            int[] last = new int[26];
            for(int i = 0; i < S.length(); i++) {
                last[S.charAt(i) - 'a'] = i;
            }
            int index = 0;
            int anchor = 0;
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < S.length(); i++) {
                index = Math.max(index, last[S.charAt(i) - 'a']);
                if(i == index) {
                    res.add(i - anchor + 1);
                    anchor = i + 1;
                }
            }
            return res;
        }
    }
}
