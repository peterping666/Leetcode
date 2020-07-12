package Laicode;

public class _40_MergeTwoSortedLinkedLists {
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
        public ListNode merge(ListNode one, ListNode two) {
            // Write your solution here
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while(one != null && two != null) {
                if(one.value < two.value) {
                    tail.next = one;
                    one = one.next;
                } else {
                    tail.next = two;
                    two = two.next;
                }
                tail = tail.next;
            }
            if(one != null) {
                tail.next = one;
            }
            if(two != null) {
                tail.next = two;
            }
            return dummy.next;
        }
    }

}
