public class _25_ReverseNodesinkGroup {
    /**
     * Time O(n)
     * Space O(n/k)
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while(cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if(count == k) {
            cur = reverseKGroup(cur, k);
            while(count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }

        return head;
    }
}
