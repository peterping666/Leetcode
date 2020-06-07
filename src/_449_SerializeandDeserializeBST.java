import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _449_SerializeandDeserializeBST {
    /**
     * Time O(n)
     * Space O(h)
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            sb.append(cur.val + " ");
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        return sb.toString();
    }

    /**
     * Time O(n)
     * Space O(n)
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] strs = data.split(" ");
        Queue<Integer> queue = new LinkedList<>();
        for(String str : strs) {
            queue.offer(Integer.parseInt(str));
        }
        return getNode(queue);
    }

    private TreeNode getNode(Queue<Integer> queue) {
        if(queue.isEmpty()) return null;
        Queue<Integer> leftNodes = new LinkedList<>();
        TreeNode root = new TreeNode(queue.poll());
        while(!queue.isEmpty() && queue.peek() < root.val) {
            leftNodes.offer(queue.poll());
        }
        root.left = getNode(leftNodes);
        root.right = getNode(queue);
        return root;
    }
}
