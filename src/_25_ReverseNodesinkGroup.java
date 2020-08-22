public class _25_ReverseNodesinkGroup {
    /**
     * Time O(n)
     * Space O(n/k)
     * @return
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null) {
                return head;
            }
            ListNode cur = head;
            for(int i = 0; cur != null && i < k - 1; i++) {
                cur = cur.next;
            }
            if(cur == null) {
                return head;
            }
            ListNode nextHead = cur.next;
            cur.next = null;
            ListNode newHead = reverse(head);
            head.next = reverseKGroup(nextHead, k);
            return newHead;
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null;
            while(head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
}
