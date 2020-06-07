import java.util.LinkedList;
import java.util.List;

public class _272_ClosestBinarySearchTreeValueII {
    /**
     * Time O(n)
     * Space O(h)
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        helper(root, target, k, res);
        return res;
    }

    private void helper(TreeNode root, double target, int k, List<Integer> res) {
        if(root == null) return;
        helper(root.left, target, k, res);
        if(res.size() == k){
            if(Math.abs(res.get(0) - target) > Math.abs(root.val - target)){
                res.remove(0);
            }else {
                return;
            }
        }
        res.add(root.val);
        helper(root.right, target, k, res);
    }
}
