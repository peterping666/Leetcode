import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _508_MostFrequentSubtreeSum {
    /**
     * Time O(n)
     * Space O(h)
     */
    int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(root == null) return new int[]{};
        helper(root, map);
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()) {
            if(map.get(key) == maxCount) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int helper(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null) return 0;
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(map.get(sum), maxCount);
        return sum;
    }
}
