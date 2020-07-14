public class _430_FlattenaMultilevelDoublyLinkedList {
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

    class Solution {
        /**
         * Time O(n)
         * Space O(n)
         * @param head
         * @return
         */
        public Node flatten(Node head) {
            Node cur = head;
            while(cur != null) {
                if(cur.child != null) {
                    Node right = cur.next;
                    cur.next = flatten(cur.child);
                    cur.next.prev = cur;
                    cur.child = null;
                    while(cur.next != null) {
                        cur = cur.next;
                    }
                    if(right != null) {
                        cur.next = right;
                        right.prev = cur;
                    }
                }
                cur = cur.next;
            }
            return head;
        }
    }
}
