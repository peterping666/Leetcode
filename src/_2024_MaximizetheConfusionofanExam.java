public class _2024_MaximizetheConfusionofanExam {
    class Solution {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            return Math.max(helper(answerKey, k, 'T'), helper(answerKey, k, 'F'));
        }

        private int helper(String s, int k, char base) {
            int res = 0;
            for(int i = 0, j = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == base) {
                    k--;
                    while(k < 0) {
                        if(s.charAt(j++) == base) {
                            k++;
                        }
                    }
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }
}
