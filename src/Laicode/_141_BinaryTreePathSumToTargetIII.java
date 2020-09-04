package Laicode;

import java.util.HashSet;
import java.util.Set;

public class _141_BinaryTreePathSumToTargetIII {
    public class Solution {
        public boolean exist(TreeNode root, int target) {
            Set<Integer> set = new HashSet<>();
            set.add(0);
            return helper(root, set, target, 0);
        }

        private boolean helper(TreeNode root, Set<Integer> set, int target, int sum) {
            if(root == null) {
                return false;
            }
            sum += root.key;
            if(set.contains(sum - target)) {
                return true;
            }
            boolean needRemove = set.add(sum);
            if(helper(root.left, set, target, sum) || helper(root.right, set, target, sum)) {
                return true;
            }
            if(needRemove) {
                set.remove(sum);
            }
            return false;
        }
    }
}
