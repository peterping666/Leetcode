public class _1358_NumberofSubstringsContainingAllThreeCharacters {
    class Solution {
        public int numberOfSubstrings(String s) {
            int counter = 3;
            int[] count = new int[3];
            int res = 0;
            int n = s.length();
            for(int i = 0, j = 0; i < n; i++) {
                if(count[s.charAt(i) - 'a']++ == 0) {
                    counter--;
                }
                while (counter == 0) {
                    res += n - i;
                    if(--count[s.charAt(j++) - 'a'] == 0) {
                        counter++;
                    }
                }
            }
            return res;
        }
    }
}
