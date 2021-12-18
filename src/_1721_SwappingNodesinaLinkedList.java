public class _1721_SwappingNodesinaLinkedList {

    /**
     * one pass
     */
    class Solution1 {
        public ListNode swapNodes(ListNode head, int k) {
            ListNode fast = head;
            while(--k > 0) {
                fast = fast.next;
            }
            ListNode knode = fast;
            ListNode slow = head;
            while(fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            int tmp = knode.val;
            knode.val = slow.val;
            slow.val = tmp;
            return head;
        }
    }

    /**
     * two passes
     */
    class Solution2 {
        public ListNode swapNodes(ListNode head, int k) {
            ListNode bknode = beginK(head, k);
            ListNode eknode = endK(head, k);
            int tmp = bknode.val;
            bknode.val = eknode.val;
            eknode.val = tmp;
            return head;
        }

        private ListNode beginK(ListNode head, int k) {
            while(--k > 0) {
                head = head.next;
            }
            return head;
        }

        private ListNode endK(ListNode head, int k) {
            ListNode fast = head;
            while(k-- > 0) {
                fast = fast.next;
            }
            while(fast != null) {
                head = head.next;
                fast = fast.next;
            }
            return head;
        }
    }
}
