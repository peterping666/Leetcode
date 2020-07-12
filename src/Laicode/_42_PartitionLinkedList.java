package Laicode;

public class _42_PartitionLinkedList {
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
        public ListNode partition(ListNode head, int target) {
            // Write your solution here
            if(head == null || head.next == null) {
                return head;
            }
            ListNode dummy1 = new ListNode(1);
            ListNode dummy2 = new ListNode(2);
            ListNode tail1 = dummy1;
            ListNode tail2 = dummy2;
            while(head != null) {
                if(head.value < target) {
                    tail1.next = head;
                    tail1 = tail1.next;
                } else {
                    tail2.next = head;
                    tail2 = tail2.next;
                }
                head = head.next;
            }
            tail1.next = dummy2.next;
            tail2.next = null;
            return dummy1.next;
        }
    }

}
