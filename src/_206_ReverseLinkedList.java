class ReverseLinkedList {

    /**
     * Time O(n)
     * Space O(1)
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while(head != null) {
            ListNode nextNode = head.next;
            head.next = head;
            pre = head;
            head = nextNode;
        }
        return pre;
    }

    /**
     * Time O(n)
     * Space O(n)
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
