import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429_NaryTreeLevelOrderTraversal {
    /**
     * Time O(n)
     * Space O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                Node cur = queue.poll();
                for(Node child : cur.children) {
                    if(child != null) {
                        queue.offer(child);
                    }
                }
                list.add(cur.val);
            }
            res.add(list);
        }
        return res;
    }
}
