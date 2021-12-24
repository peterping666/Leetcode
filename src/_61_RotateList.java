public class _61_RotateList {

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            int len = getLen(head);
            if(len == 0 || k % len == 0) {
                return head;
            }
            k %= len;
            ListNode tail = head;
            while(k-- > 0) {
                tail = tail.next;
            }
            ListNode newTail = head;
            while(tail.next != null) {
                tail = tail.next;
                newTail = newTail.next;
            }
            ListNode newHead = newTail.next;
            newTail.next = null;
            tail.next = head;
            return newHead;
        }

        private int getLen(ListNode head) {
            int res = 0;
            while(head != null) {
                head = head.next;
                res++;
            }
            return res;
        }
    }
}
