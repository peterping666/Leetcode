public class _426_ConvertBinarySearchTreetoSortedDoublyLinkedList {
    /**
     * Time O(n)
     * Space O(h)
     */
    class Solution {
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            Node[] prev = new Node[1];
            Node dummy = new Node(0, null, null);
            prev[0] = dummy;
            connect(root, prev);
            dummy.right.left = prev[0];
            prev[0].right = dummy.right;
            return dummy.right;
        }

        private void connect(Node root, Node[] prev) {
            if(root == null) {
                return;
            }
            connect(root.left, prev);
            prev[0].right = root;
            root.left = prev[0];
            prev[0] = root;
            connect(root.right, prev);
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
