public class _821_ShortestDistancetoaCharacter {
    class Solution {
        public int[] shortestToChar(String s, char c) {
            int n = s.length(), index = -n;
            int[] res = new int[n];

            for(int i = 0; i < n; i++) {
                if(s.charAt(i) == c) {
                    index = i;
                }
                res[i] = i - index;
            }

            for(int i = index-1; i >= 0; i--) {
                if(s.charAt(i) == c) {
                    index = i;
                }
                res[i] = Math.min(res[i], index - i);
            }
            return res;
        }
    }
}
