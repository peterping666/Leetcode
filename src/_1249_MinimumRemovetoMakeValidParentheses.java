import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class _1249_MinimumRemovetoMakeValidParentheses {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution1 {
        public String minRemoveToMakeValid(String s) {
            Set<Integer> set = new HashSet<>();
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == '(') {
                    stack.offerFirst(i);
                } else if(ch == ')') {
                    if(!stack.isEmpty()) {
                        stack.pollFirst();
                    } else {
                        set.add(i);
                    }
                }
            }
            while(!stack.isEmpty()) {
                set.add(stack.pollFirst());
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                if(!set.contains(i)) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }
}
