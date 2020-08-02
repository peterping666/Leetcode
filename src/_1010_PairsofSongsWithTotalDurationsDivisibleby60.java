public class _1010_PairsofSongsWithTotalDurationsDivisibleby60 {
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int[] count = new int[60];
            int res = 0;
            for(int t : time) {
                t %= 60;
                res += count[(60 - t) % 60];
                count[t]++;
            }
            return res;
        }
    }
}
