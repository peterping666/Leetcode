import java.util.ArrayList;
import java.util.List;

public class _17_LetterCombinationsofaPhoneNumber {
    class Solution {
        public List<String> letterCombinations(String digits) {
            String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            List<String> res = new ArrayList<>();
            if(digits.length() == 0) {
                return res;
            }
            helper(res, digits, 0, new StringBuilder(), letters);
            return res;
        }

        private void helper(List<String> res, String digits, int index, StringBuilder path, String[] letters) {
            if(index == digits.length()) {
                res.add(path.toString());
                return;
            }
            String str = letters[digits.charAt(index) - '0'];
            for(int i = 0; i < str.length(); i++) {
                path.append(str.charAt(i));
                helper(res, digits, index + 1, path, letters);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
