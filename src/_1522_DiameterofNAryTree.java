public class _1522_DiameterofNAryTree {
    class Solution {
        public int diameter(Node root) {
            int[] res = new int[1];
            helper(root, res);
            return res[0];
        }

        private int helper(Node root, int[] res) {
            if(root == null) {
                return 0;
            }
            int max1 = 0;
            int max2 = 0;
            for(Node child : root.children) {
                int height = helper(child, res);
                if(height > max1) {
                    max2 = max1;
                    max1 = height;
                } else if(height > max2) {
                    max2 = height;
                }
            }
            res[0] = Math.max(res[0], max1 + max2);
            return max1 + 1;
        }
    }

    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
}
