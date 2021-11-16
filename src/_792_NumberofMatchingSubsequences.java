import java.util.ArrayList;
import java.util.List;

public class _792_NumberofMatchingSubsequences {
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            int ans = 0;
            List<StringBuilder>[] waiting = new List[128];
            for (int c = 0; c <= 'z'; c++)
                waiting[c] = new ArrayList();
            for (String w : words)
                waiting[w.charAt(0)].add(new StringBuilder(w));

            for (char c : s.toCharArray()) {
                List<StringBuilder> advance = waiting[c];

                waiting[c] = new ArrayList();

                for (StringBuilder it : advance){
                    it.deleteCharAt(0);
                    if(it.length() != 0)
                        waiting[it.charAt(0)].add(it);
                    else
                        ans++;
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public int numMatchingSubseq(String s, String[] words) {
            List<Integer[]>[] waiting = new List[128];

            for (int c = 0; c <= 'z'; c++)
                waiting[c] = new ArrayList();

            for (int i = 0; i < words.length; i++)
                waiting[words[i].charAt(0)].add(new Integer[]{i, 1});

            for (char c : s.toCharArray()) {
                List<Integer[]> advance = new ArrayList(waiting[c]);
                waiting[c].clear();
                for (Integer[] a : advance)
                    waiting[a[1] < words[a[0]].length() ? words[a[0]].charAt(a[1]++) : 0].add(a);
            }
            return waiting[0].size();
        }
    }

    class Solution2 {
        public int numMatchingSubseq(String s, String[] words) {
            int n = words.length;
            int[] indices = new int[n];

            int res = 0;
            for(int i = 0; i < s.length(); i++) {
                for(int j = 0; j < n; j++) {
                    String word = words[j];
                    int index = indices[j];
                    if(index < word.length() && s.charAt(i) == word.charAt(index)) {
                        if(++indices[j] == word.length()) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
