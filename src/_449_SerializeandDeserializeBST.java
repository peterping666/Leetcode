import java.util.Arrays;
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
     * Time O(n^2)
     * Space O(n^2)
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

    /**
     * Time O(n)
     * Space O(n)
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public TreeNode deserialize(Queue<String> q, int lower, int upper) {
            if (q.isEmpty()) return null;
            String s = q.peek();
            int val = Integer.parseInt(s);
            if (val < lower || val > upper) return null;
            q.poll();
            TreeNode root = new TreeNode(val);
            root.left = deserialize(q, lower, val);
            root.right = deserialize(q, val, upper);
            return root;
        }
    }
}
