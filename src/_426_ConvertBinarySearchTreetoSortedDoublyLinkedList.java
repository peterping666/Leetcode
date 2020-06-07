public class _426_ConvertBinarySearchTreetoSortedDoublyLinkedList {
    /**
     * Time O(n)
     * Space O(h)
     */
    Node pre = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Node dummy = new Node(0, null, null);
        pre = dummy;
        helper(root);
        dummy.right.left = pre;
        pre.right = dummy.right;
        return dummy.right;
    }

    private void helper(Node node) {
        if(node == null) return;
        helper(node.left);
        pre.right = node;
        node.left = pre;
        pre = node;
        helper(node.right);
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
