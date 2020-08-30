import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _58_GetKeysInBinaryTreeLayerByLayerZigZagOrder {
    public class Solution {
        public List<Integer> zigZag(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offerFirst(root);
            boolean isOdd = true;
            while(!deque.isEmpty()) {
                int size = deque.size();
                for(int i = 0; i < size; i++) {
                    if(isOdd) {
                        TreeNode cur = deque.pollLast();
                        res.add(cur.key);
                        if(cur.right != null) {
                            deque.offerFirst(cur.right);
                        }
                        if(cur.left != null) {
                            deque.offerFirst(cur.left);
                        }
                    } else {
                        TreeNode cur = deque.pollFirst();
                        res.add(cur.key);
                        if(cur.left != null) {
                            deque.offerLast(cur.left);
                        }
                        if(cur.right != null) {
                            deque.offerLast(cur.right);
                        }
                    }
                }
                isOdd = !isOdd;
            }
            return res;
        }
    }

    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
}


