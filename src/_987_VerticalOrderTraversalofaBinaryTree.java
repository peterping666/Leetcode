import java.util.*;

public class _987_VerticalOrderTraversalofaBinaryTree {

    class Solution1 {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            Queue<TreeNode> nodeQueue = new ArrayDeque<>();
            Queue<Integer> colQueue = new ArrayDeque<>();
            int min = 0;
            int max = 0;
            nodeQueue.offer(root);
            colQueue.offer(0);
            while(!nodeQueue.isEmpty()) {
                int size = nodeQueue.size();
                Map<Integer, List<Integer>> levelMap = new HashMap<>();
                while(size-- > 0) {
                    TreeNode node = nodeQueue.poll();
                    int col = colQueue.poll();
                    levelMap.putIfAbsent(col, new ArrayList<>());
                    levelMap.get(col).add(node.val);
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
                for(int key : levelMap.keySet()) {
                    map.putIfAbsent(key, new ArrayList<>());
                    List<Integer> list = levelMap.get(key);
                    Collections.sort(list);
                    map.get(key).addAll(list);
                }
            }
            for(int i = min; i <= max; i++) {
                res.add(map.get(i));
            }
            return res;
        }
    }

    class Solution2 {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            List<List<int[]>> lists = new ArrayList<>();
            int[] width = new int[2];
            findWidth(root, width, 0);
            for(int i = 0; i < width[0] + width[1] + 1; i++) {
                lists.add(new ArrayList<>());
                res.add(new ArrayList<>());
            }

            addVerticalValue(root, width[0], lists, 0);

            for(List<int[]> list : lists) {
                Collections.sort(list, (a, b) -> {
                    if(a[1] == b[1]) {
                        return Integer.compare(a[0], b[0]);
                    }
                    return Integer.compare(a[1], b[1]);
                });
            }

            for(int i = 0; i < lists.size(); i++) {
                for(int[] pair : lists.get(i)) {
                    res.get(i).add(pair[0]);
                }
            }

            return res;
        }

        private void addVerticalValue(TreeNode root, int index, List<List<int[]>> lists, int depth) {
            if(root == null) {
                return;
            }
            lists.get(index).add(new int[]{root.val, depth});
            addVerticalValue(root.left, index - 1, lists, depth + 1);
            addVerticalValue(root.right, index + 1, lists, depth + 1);
        }

        private void findWidth(TreeNode root, int[] width, int index) {
            if(root == null) {
                return;
            }
            if(index < 0) {
                width[0] = Math.max(width[0], -index);
            } else {
                width[1] = Math.max(width[1], index);
            }
            findWidth(root.left, width, index - 1);
            findWidth(root.right, width, index + 1);
        }
    }
}
