import java.util.*;

public class _863_AllNodesDistanceKinBinaryTree {
    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            HashMap<TreeNode, TreeNode> parent = new HashMap<>();
            dfs(root, null, parent);
            Queue<TreeNode> queue = new LinkedList<>();
            HashSet<TreeNode> seen = new HashSet<>();
            queue.offer(target);
            seen.add(target);
            List<Integer> res = new ArrayList<>();
            int dist = 0;
            while(!queue.isEmpty()) {
                if(dist == K) {
                    while(!queue.isEmpty()) {
                        res.add(queue.poll().val);
                    }
                    continue;
                }
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if(cur.left != null && !seen.contains(cur.left)) {
                        queue.offer(cur.left);
                        seen.add(cur.left);
                    }
                    if(cur.right != null && !seen.contains(cur.right)) {
                        queue.offer(cur.right);
                        seen.add(cur.right);
                    }
                    if(parent.get(cur) != null && !seen.contains(parent.get(cur))) {
                        queue.offer(parent.get(cur));
                        seen.add(parent.get(cur));
                    }
                }
                dist++;
            }
            return res;
        }

        private void dfs(TreeNode root, TreeNode prev, HashMap parent) {
            if(root == null) {
                return;
            }
            parent.put(root, prev);
            dfs(root.left, root, parent);
            dfs(root.right, root, parent);
        }
    }
}
