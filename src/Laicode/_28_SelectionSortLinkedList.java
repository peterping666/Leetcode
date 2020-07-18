package Laicode;

public class _28_SelectionSortLinkedList {
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
        public ListNode selectionSort(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while(head != null) {
                int minValue = head.value;
                ListNode minNode = head;
                ListNode prev = null;
                ListNode cur = head;

                while(cur.next != null) {
                    if(cur.next.value < minValue) {
                        minValue = cur.next.value;
                        minNode = cur.next;
                        prev = cur;
                    }
                    cur = cur.next;
                }

                tail.next = minNode;
                if(minNode == head) {
                    head = head.next;
                } else if(prev != null) {
                    prev.next = minNode.next;
                }
                minNode.next = null;
                tail = tail.next;
            }
            return dummy.next;
        }
    }

}
