public class _19_RemoveNthNodeFromEndofList {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = head;
            while(fast != null) {
                fast = fast.next;
                if(n == 0) {
                    slow = slow.next;
                } else {
                    n--;
                }
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}
