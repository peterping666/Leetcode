package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _64_AllPermutationsI {
    /**
     *
     */
    public class Solution1 {
        public List<String> permutations(String input) {
            List<String> res = new ArrayList<>();
            helper(res, input, new StringBuilder(), new boolean[input.length()]);
            return res;
        }

        private void helper(List<String> res, String input, StringBuilder path, boolean[] visited) {
            if(path.length() == input.length()) {
                res.add(path.toString());
                return;
            }
            for(int i = 0; i < input.length(); i++) {
                if(visited[i]) continue;
                visited[i] = true;
                helper(res, input, path.append(input.charAt(i)), visited);
                visited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    /**
     *
     */
    public class Solution2 {
        public List<String> permutations(String input) {
            List<String> res = new ArrayList<>();
            char[] charArray = input.toCharArray();
            helper(res, charArray, 0);
            return res;
        }

        private void helper(List<String> res, char[] input, int index) {
            if(index == input.length) {
                res.add(new String(input));
                return;
            }
            for(int i = index; i < input.length; i++) {
                swap(input, index, i);
                helper(res, input, index + 1);
                swap(input, index, i);
            }
        }

        private void swap(char[] input, int left, int right) {
            char tmp = input[left];
            input[left] = input[right];
            input[right] = tmp;
        }
    }

}
