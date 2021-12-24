import java.util.*;

public class _297_SerializeandDeserializeBinaryTree {

    /**
     * DFS
     * Time O(n)
     * Space O(n)
     */
    public class Codec1 {

        public String serialize(TreeNode root) {
            if(root == null) {
                return "#";
            }
            return root.val + "," + serialize(root.left) + "," + serialize(root.right);
        }

        public TreeNode deserialize(String data) {
            String[] strs = data.split(",");
            int n = strs.length;
            TreeNode[] nodes = new TreeNode[n];
            for(int i = 0; i < n; i++) {
                nodes[i] = strs[i].equals("#") ? null : new TreeNode(Integer.valueOf(strs[i]));
            }
            return dfs(nodes, new int[1]);
        }

        private TreeNode dfs(TreeNode[] nodes, int[] index) {
            TreeNode root = nodes[index[0]++];
            if(root == null) {
                return root;
            }
            root.left = dfs(nodes, index);
            root.right = dfs(nodes, index);
            return root;
        }
    }

    /**
     * DFS optimized
     */
    public class Codec2 {

        public String serialize(TreeNode root) {
            if(root == null) {
                return "#";
            }
            return root.val + "," + serialize(root.left) + "," + serialize(root.right);
        }

        public TreeNode deserialize(String data) {
            String[] strs = data.split(",");
            return dfs(strs, new int[1]);
        }

        private TreeNode dfs(String[] strs, int[] index) {
            TreeNode root =
                    strs[index[0]].equals("#") ? null : new TreeNode(Integer.valueOf(strs[index[0]]));
            index[0]++;
            if(root == null) {
                return root;
            }
            root.left = dfs(strs, index);
            root.right = dfs(strs, index);
            return root;
        }
    }

    /**
     * BFS
     * Time O(n)
     * Space O(n)
     */
    public class Codec3 {

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if(cur == null) {
                    sb.append("#,");
                } else {
                    sb.append(cur.val + ",");
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            String[] strs = data.split(",");
            int n = strs.length;
            TreeNode[] nodes = new TreeNode[n];
            for(int i = 0; i < n; i++) {
                nodes[i] = strs[i].equals("#") ? null : new TreeNode(Integer.valueOf(strs[i]));
            }
            for(int i = 0, j = 1; j < n; i++) {
                TreeNode root = nodes[i];
                if(root != null) {
                    root.left = nodes[j];
                    root.right = nodes[j+1];
                    j += 2;
                }
            }
            return nodes[0];
        }
    }
}
