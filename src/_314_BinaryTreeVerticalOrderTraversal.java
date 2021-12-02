import java.util.*;

public class _314_BinaryTreeVerticalOrderTraversal {

    class Solution1 {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            Queue<TreeNode> nodeQueue = new ArrayDeque<>();
            Queue<Integer> colQueue = new ArrayDeque<>();
            int min = 0;
            int max = 0;
            nodeQueue.offer(root);
            colQueue.offer(0);
            while(!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                int col = colQueue.poll();
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(node.val);
                if(node.left != null) {
                    nodeQueue.offer(node.left);
                    colQueue.offer(col-1);
                    min = Math.min(min, col-1);
                }
                if(node.right != null) {
                    nodeQueue.offer(node.right);
                    colQueue.offer(col+1);
                    max = Math.max(max, col+1);
                }
            }
            for(int i = min; i <= max; i++) {
                res.add(map.get(i));
            }
            return res;
        }
    }

    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution2 {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if(root == null) {
                return lists;
            }
            int[] width = new int[2];
            calcWidth(root, width, 0);
            for(int i = 0; i < width[1] - width[0] + 1; i++) {
                lists.add(new ArrayList<>());
            }
            bfs(root, lists, -width[0]);
            return lists;
        }

        private void bfs(TreeNode root, List<List<Integer>> lists, int rootIndex) {
            Queue<TreeNode> nodeQueue = new ArrayDeque<>();
            Queue<Integer> indexQueue = new ArrayDeque<>();
            nodeQueue.offer(root);
            indexQueue.offer(rootIndex);
            while(!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                int index = indexQueue.poll();
                lists.get(index).add(node.val);
                if(node.left != null) {
                    nodeQueue.offer(node.left);
                    indexQueue.offer(index - 1);
                }
                if(node.right != null) {
                    nodeQueue.offer(node.right);
                    indexQueue.offer(index + 1);
                }
            }
        }

        private void calcWidth(TreeNode root, int[] width, int index) {
            if(root == null) {
                return;
            }
            width[0] = Math.min(width[0], index);
            width[1] = Math.max(width[1], index);
            calcWidth(root.left, width, index - 1);
            calcWidth(root.right, width, index + 1);
        }
    }
}
