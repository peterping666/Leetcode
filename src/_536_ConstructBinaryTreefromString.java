import java.util.ArrayDeque;
import java.util.Deque;

public class _536_ConstructBinaryTreefromString {
    class Solution {
        public TreeNode str2tree(String s) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == ')') {
                    stack.pollFirst();
                } else if(c >= '0' && c <= '9' || c == '-') {
                    int j = i;
                    while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        i++;
                    }
                    TreeNode newNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                    if(!stack.isEmpty()) {
                        TreeNode parent = stack.peekFirst();
                        if(parent.left == null) {
                            parent.left = newNode;
                        } else {
                            parent.right = newNode;
                        }
                    }
                    stack.offerFirst(newNode);
                }
            }
            return stack.isEmpty() ? null : stack.peekFirst();
        }
    }
}
