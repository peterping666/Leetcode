public class _92_ReverseLinkedList2 {
    /**
     * Time O(n)
     * space O(1)
     * @return
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode cur = head;
            ListNode prev = null;
            while(m > 1) {
                prev = cur;
                cur = cur.next;
                m--;
                n--;
            }
            ListNode tailPrev = prev;
            ListNode tail = cur;
            while(n > 0) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                n--;
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
