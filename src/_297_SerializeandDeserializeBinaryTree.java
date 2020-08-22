import java.util.ArrayDeque;
import java.util.Queue;

public class _297_SerializeandDeserializeBinaryTree {
    /**
     * Time O(n)
     * Space O(n)
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        sb.append(root.val + " ");
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur.left != null) {
                q.offer(cur.left);
                sb.append(cur.left.val + " ");
            } else {
                sb.append("# ");
            }
            if(cur.right != null) {
                q.offer(cur.right);
                sb.append(cur.right.val + " ");
            } else {
                sb.append("# ");
            }
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
        if(data.length() == 0) {
            return null;
        }
        String[] strs = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int index = 1;
        while(index < strs.length) {
            TreeNode cur = q.poll();
            String left = strs[index++];
            if(!left.equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(left));
                q.offer(cur.left);
            }

            String right = strs[index++];
            if(!right.equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(right));
                q.offer(cur.right);
            }
        }
        return root;
    }
}
