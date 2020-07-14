public class _234_PalindromeLinkedList {
    /**
     * Time O(n)
     * Space O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode midHead = reverse(mid.next);
        mid.next = null;
        while(midHead != null) {
            if(head.val != midHead.val) {
                return false;
            }
            head = head.next;
            midHead = midHead.next;
        }
        return true;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
