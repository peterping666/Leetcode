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
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, sum, map, 0);

    }
    private int helper(TreeNode node, int sum, HashMap<Integer, Integer> map, int pathSum) {
        if(node == null) {
            return 0;
        }
        pathSum += node.val;
        int count = map.getOrDefault(pathSum - sum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        count += helper(node.left, sum, map, pathSum) + helper(node.right, sum, map, pathSum);
        map.put(pathSum, map.get(pathSum) - 1);
        return count;
    }
}
