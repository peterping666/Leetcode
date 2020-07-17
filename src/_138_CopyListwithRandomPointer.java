import java.util.HashMap;

public class _138_CopyListwithRandomPointer {
    class Solution {
        /**
         * Time O(n)
         * Space O(n)
         * @param head
         * @return
         */
        public Node copyRandomList(Node head) {
            Node dummy = new Node(0);
            Node tail = dummy;
            Node cur = head;
            HashMap<Node, Node> visited = new HashMap<>();
            while(cur != null) {
                if(!visited.containsKey(cur)) {
                    visited.put(cur, new Node(cur.val));
                }
                tail.next = visited.get(cur);
                if(cur.random != null) {
                    if(!visited.containsKey(cur.random)) {
                        visited.put(cur.random, new Node(cur.random.val));
                    }
                    tail.next.random = visited.get(cur.random);
                }

                tail = tail.next;
                cur = cur.next;
            }
            return dummy.next;
        }



        class Node {
            int val;
            Node next;
            Node random;

            public Node(int val) {
                this.val = val;
                this.next = null;
                this.random = null;
            }
        }
    }
}


