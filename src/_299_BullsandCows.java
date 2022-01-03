public class _299_BullsandCows {
    class Solution {
        public String getHint(String secret, String guess) {
            int bull = 0, cow = 0;
            int[] count = new int[10];
            for(int i = 0; i < guess.length(); i++) {
                char c = guess.charAt(i);
                char ch = secret.charAt(i);
                if(c == ch) {
                    bull++;
                } else {
                    if(++count[c - '0'] <= 0) {
                        cow++;
                    }
                    if(--count[ch - '0'] >= 0) {
                        cow++;
                    }
                }
            }
            return bull + "A" + cow + "B";
        }
    }
}
