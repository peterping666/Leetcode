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
        if(root == null) return "#";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) {
                sb.append("#,");
                continue;
            }
            sb.append(cur.val + ",");
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
        if(data.equals("#")) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.offer(root);
        for(int i = 1; i < strs.length; i++) {
            TreeNode cur = queue.poll();
            if(!strs[i].equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(cur.left);
            }
            i++;
            if(!strs[i].equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
