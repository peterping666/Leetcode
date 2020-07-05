import java.util.HashMap;

public class _337_HouseRobberIII {
    /**
     * Time O(n)
     * Space O(n)
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        return helper(root, new HashMap<>());
    }

    private int helper(TreeNode root, HashMap<TreeNode, Integer> map) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int val = root.val;
        if(root.left != null) {
            val += helper(root.left.left, map) + helper(root.left.right, map);
        }
        if(root.right != null) {
            val += helper(root.right.left, map) + helper(root.right.right, map);
        }
        val = Math.max(val, helper(root.left, map) + helper(root.right, map));
        map.put(root, val);
        return val;
    }
}
