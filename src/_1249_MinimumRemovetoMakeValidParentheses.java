import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class _1249_MinimumRemovetoMakeValidParentheses {
    class Solution1 {
        public String minRemoveToMakeValid(String s) {
            Set<Integer> indexToRemove = new HashSet<>();
            Deque<Integer> stack = new ArrayDeque<>();

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(stack.isEmpty() && c == ')') {
                    indexToRemove.add(i);
                }
                if(c == '(') {
                    stack.offerFirst(i);
                } else if(c == ')') {
                    stack.pollFirst();
                }
            }
            while(!stack.isEmpty()) {
                indexToRemove.add(stack.pollFirst());
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                if(!indexToRemove.contains(i)) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }

    class Solution2 {

        public String minRemoveToMakeValid(String s) {
            // Parse 1: Remove all invalid ")"
            StringBuilder sb = new StringBuilder();
            int openSeen = 0;
            int balance = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    openSeen++;
                    balance++;
                } if (c == ')') {
                    if (balance == 0) continue;
                    balance--;
                }
                sb.append(c);
            }

            // Parse 2: Remove the rightmost "("
            StringBuilder result = new StringBuilder();
            int openToKeep = openSeen - balance;
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == '(') {
                    openToKeep--;
                    if (openToKeep < 0) continue;
                }
                result.append(c);
            }

            return result.toString();
        }
    }
}
