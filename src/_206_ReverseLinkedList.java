public class _206_ReverseLinkedList {
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

    class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            while(head != null) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            return newHead;
        }
    }
}
