package Laicode;

public class _29_MergeSortLinkedList {
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
        public ListNode mergeSort(ListNode head) {
            // Write your solution here
            if(head == null || head.next == null) {
                return head;
            }
            ListNode mid = midNode(head);
            ListNode midNext = mid.next;
            mid.next = null;
            ListNode left = mergeSort(head);
            ListNode right = mergeSort(midNext);
            return merge(left, right);
        }

        private ListNode merge(ListNode one, ListNode two) {
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
            } else {
                tail.next = two;
            }
            return dummy.next;
        }

        private ListNode midNode(ListNode head) {
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
