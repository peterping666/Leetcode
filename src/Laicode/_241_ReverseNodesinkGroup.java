package Laicode;

public class _241_ReverseNodesinkGroup {
    /**
     * Time O(n)
     * Space O(1)
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your solution here
        if(head == null) {
            return head;
        }
        ListNode cur = head;
        int count = 1;
        while(count < k && cur.next != null) {
            count++;
            cur = cur.next;
        }
        if(count < k) {
            return head;
        }
        ListNode nextHead = reverseKGroup(cur.next, k);
        cur.next = null;
        ListNode newHead = reverse(head);
        head.next = nextHead;
        return newHead;
    }

    private ListNode reverse(ListNode head) {
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
