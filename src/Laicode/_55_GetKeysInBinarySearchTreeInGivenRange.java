package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _55_GetKeysInBinarySearchTreeInGivenRange {
    public class Solution {
        public List<Integer> getRange(TreeNode root, int min, int max) {
            List<Integer> list = new ArrayList<>();
            helper(root, min, max, list);
            return list;
        }

        private void helper(TreeNode root, int min, int max, List<Integer> list) {
            if(root == null) {
                return;
            }

            if(root.key > min) {
                helper(root.left, min, max, list);
            }

            if(root.key >= min && root.key <= max) {
                list.add(root.key);
            }
            if(root.key < max) {
                helper(root.right, min, max, list);
            }
        }
    }
}
