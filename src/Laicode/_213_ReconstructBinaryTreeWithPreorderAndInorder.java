package Laicode;

import java.util.HashMap;
import java.util.Map;

public class _213_ReconstructBinaryTreeWithPreorderAndInorder {
    public class Solution {
        public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < inOrder.length; i++) {
                map.put(inOrder[i], i);
            }
            return helper(0, inOrder.length - 1, preOrder,
                    0, preOrder.length - 1, map);
        }

        private TreeNode helper(int inLeft, int inRight, int[] preOrder,
                                int preLeft, int preRight, Map<Integer, Integer> map) {
            if(inLeft > inRight) {
                return null;
            }
            TreeNode root = new TreeNode(preOrder[preLeft]);
            int index = map.get(root.key);
            int leftSize = index - inLeft;
            root.left = helper(inLeft, index - 1, preOrder,
                    preLeft + 1, preLeft + leftSize, map);
            root.right = helper(index + 1, inRight, preOrder,
                    preLeft + leftSize + 1, preRight, map);
            return root;
        }
    }
}
