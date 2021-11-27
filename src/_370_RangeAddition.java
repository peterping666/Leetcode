public class _370_RangeAddition {
    class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] res = new int[length];
            for(int[] update : updates) {
                res[update[0]] += update[2];
                if(update[1] + 1 < length) {
                    res[update[1] + 1] -= update[2];
                }
            }
            int cur = 0;
            for(int i = 0; i < length; i++) {
                cur += res[i];
                res[i] = cur;
            }
            return res;
        }
    }
}
