package Laicode;

public class _35_ReverseLinkedListInPairs {
    /**
     * Recursive way
     * @param head
     * @return
     */
    public ListNode reverseInPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = reverseInPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * Iterative way
     * @param head
     * @return
     */
    public ListNode reverseInPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        tail.next = head;
        while(tail.next != null && tail.next.next != null) {
            ListNode next = tail.next.next;
            tail.next.next = tail.next.next.next;
            next.next = tail.next;
            tail.next = next;
            tail = tail.next.next;
        }
        return dummy.next;
    }
}
