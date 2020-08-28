public class _203_RemoveLinkedListElements {
    /**
     * Time O(n)
     * space O(1)
     * @return
     */
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while(head != null) {
                if(head.val != val) {
                    tail.next = head;
                    tail = tail.next;
                } else {
                    tail.next = null;
                }
                head = head.next;
            }
            return dummy.next;
        }
    }
}
