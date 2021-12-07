import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class _792_NumberofMatchingSubsequences {

    /**
     * Time O(n + kL^2)
     */
    class Solution1 {
        public int numMatchingSubseq(String s, String[] words) {
            List<String>[] waiting = new ArrayList[26];
            for(int i = 0; i < 26; i++) {
                waiting[i] = new ArrayList<>();
            }
            for(String word : words) {
                waiting[word.charAt(0) - 'a'].add(word);
            }
            int res = 0;
            for(int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                List<String> list = waiting[index];
                waiting[index] = new ArrayList<>();
                for(String str : list) {
                    if(str.length() == 1) {
                        res++;
                    } else {
                        String next = str.substring(1);
                        waiting[next.charAt(0) - 'a'].add(next);
                    }
                }
            }
            return res;
        }
    }

    /**
     * Time O(26n + kL)
     */
    class Solution2 {
        public int numMatchingSubseq(String s, String[] words) {
            int n = s.length();
            int[][] pos = new int[n+1][26];
            Arrays.fill(pos[n], -1);
            for(int i = n; i >= 1; i--) {
                for(int j = 0; j < 26; j++) {
                    pos[i-1][j] = pos[i][j];
                }
                pos[i-1][s.charAt(i-1) - 'a'] = i;
            }
            int res = 0;
            for(String word : words) {
                if(match(word, pos)) {
                    res++;
                }
            }
            return res;
        }

        private boolean match(String word, int[][] pos) {
            int cur = 0;
            for(int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(pos[cur][index] == -1) {
                    return false;
                }
                cur = pos[cur][index];
            }
            return true;
        }
    }

    /**
     * Time O(n + L * k * log(n))   n = s.length(), k = words.length, L = max(words[i].length())
     */
    class Solution3 {
        public int numMatchingSubseq(String s, String[] words) {
            TreeSet<Integer>[] pos = new TreeSet[26];
            for(int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if(pos[index] == null) {
                    pos[index] = new TreeSet<>();
                }
                pos[index].add(i);
            }
            int res = 0;
            for(String word : words) {
                if(match(word, pos)) {
                    res++;
                }
            }
            return res;
        }

        private boolean match(String word, TreeSet<Integer>[] pos) {
            int cur = -1;
            for(int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(pos[index] == null) {
                    return false;
                }
                Integer next = pos[index].higher(cur);
                if(next == null) {
                    return false;
                }
                cur = next;
            }
            return true;
        }
    }
}
