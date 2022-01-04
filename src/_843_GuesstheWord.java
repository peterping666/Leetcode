import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _843_GuesstheWord {
    /**
     * Time O(n)
     */
    class Solution {
        public void findSecretWord(String[] wordlist, Master master) {
            for(int i = 0; i < 10; i++) {
                String guess = wordlist[new Random().nextInt(wordlist.length)];
                int x = master.guess(guess);
                if(x == 6) {
                    return;
                }
                List<String> list = new ArrayList<>();
                for(String word : wordlist) {
                    if(match(guess, word) == x) {
                        list.add(word);
                    }
                }
                wordlist = list.toArray(new String[0]);
            }
        }

        private int match(String word1, String word2) {
            int count = 0;
            for(int i = 0; i < word1.length(); i++) {
                if(word1.charAt(i) == word2.charAt(i)) {
                    count++;
                }
            }
            return count;
        }
    }

    class Master {
        public int guess(String word) {
            return 0;
        }
    }
}
