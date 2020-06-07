public class _235_LCAofBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        if(root == null || root == p || root == q) {
            return root;
        }
        root.left = lowestCommonAncestor(root.left, p, q);
        root.right = lowestCommonAncestor(root.right, p, q);
        if(root.left != null && root.right != null) {
            return root;
        }
        return root.left == null? root.right : root.left;
        */
        /*
        if(root == null) {
            return null;
        }
        while(root.val < p.val && root.val < q.val || root.val > p.val && root.val > q.val) {
            if(root.val < p.val && root.val < q.val) {
                root = root.right;
            }
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
            }
        }
        return root;
        */
        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }else if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
