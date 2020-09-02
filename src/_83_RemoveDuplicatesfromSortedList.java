public class _83_RemoveDuplicatesfromSortedList {
    /**
     * Time O(n)
     * Space O(1)
     * @return
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null) {
                return null;
            }
            ListNode tail = head;
            ListNode cur = head;
            while(cur != null) {
                cur = cur.next;
                if(cur != null && cur.val != tail.val) {
                    tail.next = cur;
                    tail = tail.next;
                }
            }
            tail.next = null;
            return head;
        }
    }
}
