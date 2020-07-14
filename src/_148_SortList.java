public class _148_SortList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * Time O(nlogn)
         * Space O(1)
         * @param head
         * @return
         */
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode mid = midNode(head);
            ListNode midHead = mid.next;
            mid.next = null;
            head = sortList(head);
            midHead = sortList(midHead);
            return merge(head, midHead);
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while(left != null && right != null) {
                if(left.val < right.val) {
                    tail.next = left;
                    left = left.next;
                } else {
                    tail.next = right;
                    right = right.next;
                }
                tail = tail.next;
            }
            if(left != null) {
                tail.next = left;
            } else {
                tail.next = right;
            }
            return dummy.next;
        }

        private ListNode midNode(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode fast = head;
            ListNode slow = head;
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
