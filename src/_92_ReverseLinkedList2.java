public class _92_ReverseLinkedList2 {
    /**
     * Time O(n)
     * space O(1)
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode cur = head;
            ListNode prev = null;
            while(--m > 0) {
                prev = cur;
                cur = cur.next;
                n--;
            }
            ListNode tailPrev = prev;
            ListNode tail = cur;
            while(n-- > 0) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            if(tailPrev == null) {
                head = prev;
            } else {
                tailPrev.next = prev;
            }
            tail.next = cur;
            return head;
        }
    }
}
