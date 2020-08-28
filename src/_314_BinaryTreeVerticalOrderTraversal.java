import java.util.*;

public class _314_BinaryTreeVerticalOrderTraversal {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution1 {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            int[] range = new int[2];
            getRange(root, range, 0, 0);
            for(int i = 0; i <= range[0] + range[1]; i++) {
                res.add(new ArrayList<>());
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            Queue<Integer> index = new ArrayDeque<>();

            queue.offer(root);
            index.offer(range[0]);

            while(!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                int curIndex = index.poll();

                res.get(curIndex).add(cur.val);

                if(cur.left != null) {
                    queue.offer(cur.left);
                    index.offer(curIndex - 1);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                    index.offer(curIndex + 1);
                }
            }
            return res;
        }

        private void getRange(TreeNode root, int[] range, int left, int right) {
            if(root == null) {
                return;
            }
            range[0] = Math.max(range[0], left);
            range[1] = Math.max(range[1], right);

            getRange(root.left, range, left + 1, right - 1);
            getRange(root.right, range, left - 1, right + 1);
        }
    }
}
