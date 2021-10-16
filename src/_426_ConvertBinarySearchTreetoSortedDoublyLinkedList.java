public class _426_ConvertBinarySearchTreetoSortedDoublyLinkedList {
    /**
     * Time O(n)
     * Space O(h)
     */
    class Solution {
        public Node treeToDoublyList(Node root) {
            if(root == null) {
                return null;
            }
            Node[] prev = new Node[1];
            Node dummy = new Node();
            prev[0] = dummy;
            helper(root, prev);
            dummy.right.left = prev[0];
            prev[0].right = dummy.right;
            return dummy.right;
        }

        private void helper(Node root, Node[] prev) {
            if(root == null) {
                return;
            }
            helper(root.left, prev);
            root.left = prev[0];
            prev[0].right = root;
            prev[0] = root;
            helper(root.right, prev);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
