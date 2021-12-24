import java.util.ArrayList;
import java.util.List;

public class _222_CountCompleteTreeNodes {

    class Solution1 {
        public int countNodes(TreeNode root) {
            int height = getHeight(root);
            int left = (int)Math.pow(2, height-1);
            int right = (int)Math.pow(2, height)-1;
            while(left < right) {
                int mid = right - (right - left) / 2;
                if(hasK(root, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private int getHeight(TreeNode root) {
            int res = 0;
            while(root != null) {
                root = root.left;
                res++;
            }
            return res;
        }

        private boolean hasK(TreeNode root, int target) {
            List<Integer> list = new ArrayList<>();
            while(target != 1) {
                list.add(target);
                target /= 2;
            }
            list.add(1);
            for(int i = list.size() - 1; i > 0; i--) {
                if(list.get(i) * 2 == list.get(i-1)) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return root != null;
        }
    }
}
