import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class _662_MaximumWidthofBinaryTree {

    class Solution1 {
        public int widthOfBinaryTree(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            Queue<Integer> marks = new ArrayDeque<>();
            queue.offer(root);
            marks.offer(0);
            int res = 1;
            while(!queue.isEmpty()) {
                int size = queue.size();
                int left = 0, right = 0;
                for(int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    int mark = marks.poll();

                    if(i == 0) {
                        left = mark;
                    }
                    if(i == size - 1) {
                        right = mark;
                    }
                    if(node.left != null) {
                        queue.offer(node.left);
                        marks.offer(mark * 2 + 1);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                        marks.offer(mark * 2 + 2);
                    }
                }
                res = Math.max(res, right - left + 1);
            }
            return res;
        }
    }

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
