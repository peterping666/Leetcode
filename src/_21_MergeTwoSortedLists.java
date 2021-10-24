public class _21_MergeTwoSortedLists {

    class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while(l1 != null && l2 != null) {
                if(l1.val <= l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
            tail.next = l1 == null ? l2 : l1;
            return dummy.next;
        }
    }
}
