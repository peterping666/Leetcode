import java.util.*;

public class _863_AllNodesDistanceKinBinaryTree {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution1 {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
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
                    if(k == 0) {
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
                if(k-- < 0) {
                    break;
                }
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

    class Solution2{
        Map<TreeNode, Integer> map = new HashMap<>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> res = new LinkedList<>();
            find(root, target);
            dfs(root, target, K, map.get(root), res);
            return res;
        }

        private int find(TreeNode root, TreeNode target) {
            if (root == null) return -1;
            if (root == target) {
                map.put(root, 0);
                return 0;
            }
            int left = find(root.left, target);
            if (left >= 0) {
                map.put(root, left + 1);
                return left + 1;
            }
            int right = find(root.right, target);
            if (right >= 0) {
                map.put(root, right + 1);
                return right + 1;
            }
            return -1;
        }

        private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
            if (root == null) return;
            if (map.containsKey(root)) length = map.get(root);
            if (length == K) res.add(root.val);
            dfs(root.left, target, K, length + 1, res);
            dfs(root.right, target, K, length + 1, res);
        }
    }

    class Solution3 {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> res = new LinkedList<>();
            if (K == 0) {
                res.add(target.val);
            } else {
                dfs(res, root, target.val, K ,0);
            }
            return res;
        }

        private int dfs(List<Integer> res, TreeNode node, int target, int K, int depth) {
            if (node == null) return 0;

            if (depth == K) {
                res.add(node.val);
                return 0;
            }

            int left, right;
            if (node.val == target || depth > 0) {
                left = dfs(res, node.left, target, K, depth + 1);
                right = dfs(res, node.right, target, K, depth + 1);
            } else {
                left = dfs(res, node.left, target, K, depth);
                right = dfs(res, node.right, target, K, depth);
            }

            if (node.val == target) return 1;

            if (left == K || right == K) {
                res.add(node.val);
                return 0;
            }

            if (left > 0) {
                dfs(res, node.right, target, K, left + 1);
                return left + 1;
            }

            if (right > 0) {
                dfs(res, node.left, target, K, right + 1);
                return right + 1;
            }

            return 0;
        }
    }
}
