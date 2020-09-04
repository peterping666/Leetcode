package Laicode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _215_ReconstructBinaryTreeWithLevelorderAndInorder {
    public class Solution {
        public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < inOrder.length; i++) {
                map.put(inOrder[i], i);
            }
            List<Integer> list = new LinkedList<>();
            for(int num : levelOrder) {
                list.add(num);
            }
            return helper(list, map);
        }

        private TreeNode helper(List<Integer> levelOrder, Map<Integer, Integer> map) {
            if(levelOrder.isEmpty()) {
                return null;
            }
            TreeNode root = new TreeNode(levelOrder.remove(0));
            List<Integer> left = new LinkedList<>();
            List<Integer> right = new LinkedList<>();
            int index = map.get(root.key);
            for(int num : levelOrder) {
                if(map.get(num) < index) {
                    left.add(num);
                } else {
                    right.add(num);
                }
            }
            root.left = helper(left, map);
            root.right = helper(right, map);
            return root;
        }
    }

}
