import java.util.ArrayList;
import java.util.List;

public class _501_FindModeinBinarySearchTree {
    /**
     * Time O(n)
     * Space O(n)
     */
    int max;
    int count;
    Integer pre;
    public int[] findMode(TreeNode root) {
        max = 0;
        count = 0;
        pre = null;
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if(root == null) return;

        helper(root.left, list);

        if(pre != null && pre == root.val) {
            count++;
        } else {
            count = 1;
        }

        if(count > max) {
            list.clear();
            max = count;
            list.add(root.val);
        } else if(count == max) {
            list.add(root.val);
        }
        pre = root.val;

        helper(root.right, list);
    }
}
