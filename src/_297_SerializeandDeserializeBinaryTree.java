import java.util.LinkedList;
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
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) {
                sb.append("null ");
                continue;
            }
            sb.append(cur.val + " ");
            queue.offer(cur.left);
            queue.offer(cur.right);
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
        String[] vals = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i = 1; i < vals.length; i++) {
            TreeNode cur = queue.poll();
            if(!vals[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(cur.left);
            }
            if(!vals[++i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
