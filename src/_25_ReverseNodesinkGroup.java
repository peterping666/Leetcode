public class _25_ReverseNodesinkGroup {
    /**
     * Time O(n)
     * Space O(n/k)
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode knode = findk(head, k);
            if(knode == null) {
                return head;
            }
            ListNode nextHead = knode.next;
            knode.next = null;
            ListNode newHead = reverse(head);
            head.next = reverseKGroup(nextHead, k);
            return newHead;
        }

        private ListNode findk(ListNode head, int k) {
            while(--k > 0 && head != null) {
                head = head.next;
            }
            return head;
        }

        private ListNode reverse(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }

        private ListNode reverse2(ListNode head) {
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
