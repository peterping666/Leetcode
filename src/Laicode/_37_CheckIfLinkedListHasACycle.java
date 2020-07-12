package Laicode;

public class _37_CheckIfLinkedListHasACycle {
    /**
     * class ListNode {
     *   public int value;
     *   public ListNode next;
     *   public ListNode(int value) {
     *     this.value = value;
     *     next = null;
     *   }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            // write your solution here
            if(head == null || head.next == null) {
                return false;
            }
            ListNode fast = head;
            ListNode slow = head;
            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if(slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
}
