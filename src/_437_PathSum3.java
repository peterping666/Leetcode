import java.util.HashMap;

public class _437_PathSum3 {

    /**
     * Time O(n^2)
     * Space O(n)
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0)
                + helper(root.left, sum - root.val)
                + helper(root.right, sum - root.val);
    }

    /**
     * Time O(n)
     * Space O(n)
     * @param root
     * @param sum
     * @return
     */
    public int pathSum2(TreeNode root, int sum) {
        if(root == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        return helper(root, sum, map, 0);
    }

    private int helper(TreeNode root, int sum, HashMap<Integer, Integer> map, int curSum) {
        if(root == null) return 0;
        curSum += root.val;
        int count = map.getOrDefault(curSum - sum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        count += helper(root.left, sum, map, curSum) + helper(root.right, sum, map, curSum);
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
        return count;
    }
}
