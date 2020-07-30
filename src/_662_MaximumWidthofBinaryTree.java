import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class _662_MaximumWidthofBinaryTree {

    class Solution1 {
        public int widthOfBinaryTree(TreeNode root) {
            Map<TreeNode, Integer> map = new HashMap<>();
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            map.put(root, 0);
            int res = 0;
            while(!q.isEmpty()) {
                int size = q.size();
                int left = 0;
                int right = 0;
                for(int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    if(i == 0) {
                        left = map.get(cur);
                    }
                    if(i == size - 1) {
                        right = map.get(cur);
                    }
                    if(cur.left != null) {
                        map.put(cur.left, map.get(cur) * 2 + 1);
                        q.offer(cur.left);
                    }
                    if(cur.right != null) {
                        map.put(cur.right, map.get(cur) * 2 + 2);
                        q.offer(cur.right);
                    }
                }
                res = Math.max(res, right - left + 1);
            }
            return res;
        }
    }

    /**
     *
     */
    class Solution2 {
        public int widthOfBinaryTree(TreeNode root) {
            Map<Integer, Integer> map = new HashMap<>();
            return dfs(root, 0, 0, map);
        }
        private int dfs(TreeNode root, int level, int index, Map<Integer, Integer> map) {
            if(root == null) {
                return 0;
            }
            if(!map.containsKey(level)) {
                map.put(level, index);
            }
            int start = map.get(level);
            int cur = index - start + 1;
            int left = dfs(root.left, level + 1, index * 2 + 1, map);
            int right = dfs(root.right, level + 1, index * 2 + 2, map);
            return Math.max(cur, Math.max(left, right));
        }
    }
}
