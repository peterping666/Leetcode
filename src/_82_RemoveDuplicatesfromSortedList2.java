public class _82_RemoveDuplicatesfromSortedList2 {
    /**
     * Time O(n)
     * Space O(1)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null && pre.next.next != null) {
            if(pre.next.val == pre.next.next.val) {
                int val = pre.next.val;
                while(pre.next != null && pre.next.val == val) {
                    pre.next = pre.next.next;
                }
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
