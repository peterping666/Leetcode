public class _299_BullsandCows {
    public String getHint(String secret, String guess) {
        int cows = 0;
        int bulls = 0;
        int[] count = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if(count[secret.charAt(i) - '0']++ < 0) cows++;
                if(count[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
