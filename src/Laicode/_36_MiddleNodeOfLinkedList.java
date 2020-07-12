package Laicode;

public class _36_MiddleNodeOfLinkedList {

    public class Solution {
        public ListNode middleNode(ListNode head) {
            // Write your solution here
            if(head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head;
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

}
