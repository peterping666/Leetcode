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

    class Solution2 {
        public List<String> letterCombinations(String digits) {
            if(digits.length() == 0) {
                return new ArrayList<>();
            }
            List<String> list = new ArrayList<>();
            char[] cur = new char[digits.length()];
            String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            dfs(digits, list, cur, 0, letters);
            return list;
        }

        private void dfs(String digits, List<String> list, char[] cur, int index, String[] letters) {
            if(index == digits.length()) {
                list.add(new String(cur));
                return;
            }
            String str = letters[digits.charAt(index) - '0'];
            for(int i = 0; i < str.length(); i++) {
                cur[index] = str.charAt(i);
                dfs(digits, list, cur, index + 1, letters);
            }

        }
    }
}


