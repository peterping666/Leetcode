package Laicode;

public class _131_DeepCopyLinkedListWithRandomPointer {

    class RandomListNode {
        public int value;
        public RandomListNode next;
        public RandomListNode random;
        public RandomListNode(int value) {
            this.value = value;
        }
    }

    public class Solution {
        /**
         *
         * @param head
         * @return
         */
        public RandomListNode copy(RandomListNode head) {
            // Write your solution here.
            if(head == null){
                return null;
            }
            RandomListNode cur = head;
            while(cur != null) {
                RandomListNode copy = new RandomListNode(cur.value);
                copy.next = cur.next;
                cur.next = copy;
                cur = cur.next.next;
            }
            cur = head;
            while(cur != null) {
                if(cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }
            RandomListNode dummy = new RandomListNode(0);
            RandomListNode tail = dummy;
            cur = head;
            while(cur != null) {
                tail.next = cur.next;
                cur.next = cur.next.next;
                tail = tail.next;
                cur = cur.next;
            }
            return dummy.next;
        }
    }
}
