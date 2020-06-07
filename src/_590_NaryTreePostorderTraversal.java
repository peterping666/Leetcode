import java.util.ArrayList;
import java.util.List;

public class _590_NaryTreePostorderTraversal {
    /**
     * Time O(n)
     * Space O(h)
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        helper(root, list);
        return list;
    }

    private void helper(Node node, List<Integer> list) {
        if(node == null) return;
        for(Node child : node.children) {
            helper(child, list);
        }
        list.add(node.val);
    }
}
