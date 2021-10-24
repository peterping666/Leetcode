public class _708_InsertintoaSortedCircularLinkedList {

    class Solution1 {
        public Node insert(Node head, int insertVal) {
            if(head == null){
                Node newNode = new Node(insertVal, null);
                newNode.next = newNode;
                return newNode;
            }
            Node cur = head;
            while(true){
                if((cur.val <= insertVal && cur.next.val >= insertVal) ||
                        (cur.val > cur.next.val && (insertVal >= cur.val || insertVal <= cur.next.val)) ||
                        cur.next == head) {
                    Node newNode = new Node(insertVal, null);
                    newNode.next = cur.next;
                    cur.next = newNode;
                    break;
                }
                cur = cur.next;
            }
            return head;
        }
    }

    /* 3 cases
        case 1: insertVal is between 2 nodes
        e.g. 1->2->4, insert 3
        condition: insertVal >= n.val && insertVal <= n.next.val

        case 2: insertVal is >= largest node value or <= smalles node value
        e.g. 1->2->4, insert 0 or 1->2->4, insert 5
        condition: n.next.val < n.val && (insertVal >= n.val || insertVal <= n.next.val)

        case 3: all the nodes in the tree have same value
        e.g. 1->1->1, insert 2
        condition: n.next == head
    */

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
}
