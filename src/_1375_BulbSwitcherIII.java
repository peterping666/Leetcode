public class _1375_BulbSwitcherIII {
    class Solution {
        public int numTimesAllBlue(int[] light) {
            int max = 0;
            int res = 0;
            for(int i = 0; i < light.length; i++) {
                max = Math.max(light[i], max);
                if(max == i + 1) {
                    res++;
                }
            }
            return res;
        }
    }
}
