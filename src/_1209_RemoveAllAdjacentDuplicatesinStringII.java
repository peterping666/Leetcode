import java.util.ArrayDeque;
import java.util.Deque;

public class _1209_RemoveAllAdjacentDuplicatesinStringII {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution1 {
        public String removeDuplicates(String s, int k) {
            int n = s.length();
            char[] stack = s.toCharArray();
            int[] count = new int[n];
            int index = 0;
            for (int i = 0; i < n; i++) {
                stack[index] = stack[i];
                if(index > 0 && stack[index - 1] == stack[i]) {
                    count[index] = count[index - 1] + 1;
                } else {
                    count[index] = 1;
                }
                if(count[index] == k) {
                    index -= k;
                }
                index++;
            }
            return new String(stack, 0, index);
        }
    }

    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution2 {
        public String removeDuplicates(String s, int k) {
            Deque<Character> charStack = new ArrayDeque<>();
            Deque<Integer> countStack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (charStack.isEmpty() || charStack.peekFirst() != c) {
                    charStack.offerFirst(c);
                    countStack.offerFirst(1);
                } else if (countStack.peekFirst() == k - 1) {
                    countStack.pollFirst();
                    charStack.pollFirst();
                } else {
                    countStack.offerFirst(countStack.pollFirst() + 1);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!charStack.isEmpty()) {
                char c = charStack.pollFirst();
                int count = countStack.pollFirst();
                while (count-- > 0) {
                    sb.append(c);
                }
            }
            return sb.reverse().toString();
        }
    }

    /**
     *
     */
    class Solution3 {
        public String removeDuplicates(String s, int k) {
            int[] count = new int[s.length()];
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()) {
                sb.append(c);
                int last = sb.length()-1;
                count[last] = 1 + (last > 0 && sb.charAt(last) == sb.charAt(last-1) ? count[last-1] : 0);
                if(count[last] >= k) sb.delete(sb.length()-k, sb.length());
            }
            return sb.toString();
        }
    }
}
