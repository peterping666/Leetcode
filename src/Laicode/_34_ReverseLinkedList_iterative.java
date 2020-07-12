package Laicode;

public class _34_ReverseLinkedList_iterative {
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
        public ListNode reverse(ListNode head) {
            // Write your solution here
            if(head == null) {
                return head;
            }
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

}
