import java.util.*;

public class _863_AllNodesDistanceKinBinaryTree {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            Map<TreeNode, TreeNode> parent = new HashMap<>();
            dfs(root, parent);
            Queue<TreeNode> queue = new ArrayDeque<>();
            Set<TreeNode> visited = new HashSet<>();
            List<Integer> res = new ArrayList<>();
            queue.offer(target);
            visited.add(target);
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if(K == 0) {
                        res.add(cur.val);
                        continue;
                    }
                    if(cur.left != null && visited.add(cur.left)) {
                        queue.offer(cur.left);
                    }
                    if(cur.right != null && visited.add(cur.right)) {
                        queue.offer(cur.right);
                    }
                    if(parent.containsKey(cur) && visited.add(parent.get(cur))) {
                        queue.offer(parent.get(cur));
                    }
                }
                K--;
            }
            return res;
        }

        private void dfs(TreeNode root, Map<TreeNode, TreeNode> parent) {
            if(root == null) {
                return;
            }
            if(root.left != null) {
                parent.put(root.left, root);
                dfs(root.left, parent);
            }
            if(root.right != null) {
                parent.put(root.right, root);
                dfs(root.right, parent);
            }
        }
    }
}
