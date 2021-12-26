import java.util.HashMap;
import java.util.Map;

public class _889_ConstructBinaryTreefromPreorderandPostorderTraversal {
    class Solution1 {
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            int n = preorder.length;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                map.put(postorder[i], i);
            }
            return helper(preorder, postorder, 0, n-1, 0, n-1, map);
        }

        private TreeNode helper(int[] preorder, int[] postorder, int prel, int prer, int posl, int posr,
                                Map<Integer, Integer> map) {
            if(prel > prer || posl > posr) {
                return null;
            }
            if(prel == prer) {
                return new TreeNode(preorder[prel]);
            }
            TreeNode root = new TreeNode(preorder[prel]);
            int index = map.get(preorder[prel + 1]);
            int len = index - posl + 1;
            root.left = helper(preorder, postorder, prel + 1, prel + len, posl, posl + len - 1, map);
            root.right = helper(preorder, postorder, prel + len + 1, prer, posl + len, posr, map);
            return root;
        }
    }

    class Solution2 {
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            int n = preorder.length;
            return helper(preorder, postorder, 0, n-1, 0, n-1);
        }

        private TreeNode helper(int[] preorder, int[] postorder, int prel, int prer, int posl, int posr) {
            if(prel > prer || posl > posr) {
                return null;
            }
            if(prel == prer) {
                return new TreeNode(preorder[prel]);
            }
            TreeNode root = new TreeNode(preorder[prel]);
            int target = preorder[prel+1], index = posl;
            while(postorder[index] != target) {
                index++;
            }
            int len = index - posl + 1;
            root.left = helper(preorder, postorder, prel + 1, prel + len, posl, posl + len - 1);
            root.right = helper(preorder, postorder, prel + len + 1, prer, posl + len, posr);
            return root;
        }
    }
}
