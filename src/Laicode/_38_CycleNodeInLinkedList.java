package Laicode;

public class _38_CycleNodeInLinkedList {
    public class Solution {
        public ListNode cycleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow) {
                    ListNode newSlow = head;
                    while(slow != newSlow) {
                        slow = slow.next;
                        newSlow = newSlow.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }
}
