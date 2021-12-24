import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _652_FindDuplicateSubtrees {

    class Solution1 {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            helper(root, res, new HashMap<>(), new HashMap<>(), new int[]{1});
            return res;
        }

        private int helper(TreeNode root, List<TreeNode> res, Map<String, Integer> idMap,
                           Map<Integer, Integer> count, int[] id) {
            if(root == null) {
                return 0;
            }
            int left = helper(root.left, res, idMap, count, id);
            int right = helper(root.right, res, idMap, count, id);
            String str = left + "," + root.val + "," + right;
            Integer curId = idMap.get(str);
            if(curId == null) {
                curId = id[0]++;
                idMap.put(str, curId);
                count.put(curId, 1);
            } else {
                count.put(curId, count.get(curId) + 1);
                if(count.get(curId) == 2) {
                    res.add(root);
                }
            }
            return curId;
        }
    }

    class Solution2 {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            helper(root, res, new HashMap<>(), new HashMap<>(), new int[]{1});
            return res;
        }

        private int helper(TreeNode root, List<TreeNode> res, Map<String, Integer> idMap,
                           Map<Integer, Integer> count, int[] id) {
            if(root == null) {
                return 0;
            }
            int left = helper(root.left, res, idMap, count, id);
            int right = helper(root.right, res, idMap, count, id);
            String str = left + "," + root.val + "," + right;
            int curId = idMap.getOrDefault(str, id[0]);
            if(curId == id[0]) {
                id[0]++;
            }
            idMap.put(str, curId);
            count.put(curId, count.getOrDefault(curId, 0) + 1);
            if(count.get(curId) == 2) {
                res.add(root);
            }
            return curId;
        }
    }
}
