package Laicode;

public class _414_RemoveLinkedListElements {
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
        public ListNode removeElements(ListNode head, int val) {
            // Write your solution here
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while(head != null) {
                if(head.value != val) {
                    tail.next = head;
                    tail = tail.next;
                }
                head = head.next;
            }
            tail.next = null;
            return dummy.next;
        }
    }

}
