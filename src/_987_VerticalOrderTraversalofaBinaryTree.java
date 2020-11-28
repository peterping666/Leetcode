import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _987_VerticalOrderTraversalofaBinaryTree {

    class Solution {
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
