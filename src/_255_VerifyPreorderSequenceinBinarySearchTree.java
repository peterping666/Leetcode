import java.util.Stack;

public class _255_VerifyPreorderSequenceinBinarySearchTree {
    /**
     * Time O(n)
     * Space O(n)
     * @param preorder
     * @return
     */
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int num : preorder) {
            if(num < min) {
                return false;
            }
            while(!stack.isEmpty() && num > stack.peek()) {
                min = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
}
