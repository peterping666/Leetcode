import java.util.HashSet;
import java.util.Set;

public class _1650_LowestCommonAncestorofaBinaryTreeIII {
    class Solution1 {
        public Node lowestCommonAncestor(Node p, Node q) {
            Node first = p;
            Node second = q;
            while (first != second) {
                first = first == null? q : first.parent;
                second = second == null? p : second.parent;
            }
            return first;
        }
    }

    class Solution2 {
        public Node lowestCommonAncestor(Node p, Node q) {
            Set<Integer> seen = new HashSet<>();
            while (p != null) {
                seen.add(p.val);
                p = p.parent;
            }
            while (q != null) {
                if (seen.contains(q.val)) return q;
                q = q.parent;
            }
            return null;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}
