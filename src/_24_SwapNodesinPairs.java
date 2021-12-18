public class _24_SwapNodesinPairs {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution1 {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode newHead = head.next;
            ListNode nextHead = newHead.next;
            newHead.next = head;
            head.next = swapPairs(nextHead);
            return newHead;
        }
    }

    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution2 {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while(head != null && head.next != null) {
                ListNode nextHead = head.next.next;
                tail.next = swap(head);
                tail = tail.next.next;
                head = nextHead;
            }
            tail.next = head;
            return dummy.next;
        }

        private ListNode swap(ListNode node) {
            ListNode newHead = node.next;
            newHead.next = node;
            node.next = null;
            return newHead;
        }
    }
}
