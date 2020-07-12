package Laicode;

public class _41_ReOrderLinkedList {
    /**
     * class ListNode {
     *   public int value;
     *   public ListNode next;
     *   public ListNode(int value) {
     *     this.value = value;
     *     next = null;
     *   }
     * }
     */
    public class Solution {
        public ListNode reorder(ListNode head) {
            // Write your solution here
            if(head == null || head.next == null) {
                return head;
            }
            ListNode midHead = findMid(head);
            ListNode tmp = midHead;
            midHead = midHead.next;
            tmp.next = null;
            midHead = reverse(midHead);
            return merge(head, midHead);
        }

        private ListNode findMid(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
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

        private ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while(head1 != null && head2 != null) {
                tail.next = head1;
                head1 = head1.next;
                tail.next.next = head2;
                head2 = head2.next;
                tail = tail.next.next;
            }
            if(head2 != null) {
                tail.next = head2;
            }
            if(head1 != null) {
                tail.next = head1;
            }
            return dummy.next;
        }
    }

}
