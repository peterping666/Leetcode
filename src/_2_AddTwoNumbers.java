public class _2_AddTwoNumbers {
    /**
     * Time O(max(m,n))
     * Space O(max(m,n))
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, curr = dummyHead;
        int sum = 0;
        while (p1 != null || p2 != null) {
            if(p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            curr.next = new ListNode(sum % 10);
            sum = sum / 10;
            curr = curr.next;
        }
        if (sum > 0) {
            curr.next = new ListNode(sum);
        }
        return dummyHead.next;
    }
}
