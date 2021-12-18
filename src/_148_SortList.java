public class _148_SortList {
    /**
     * Time O(nlogn)
     * Space O(1)
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            return mergeSort(head);
        }

        private ListNode mergeSort(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode mid = findMid(head);
            ListNode midNext = mid.next;
            mid.next = null;
            ListNode left = mergeSort(head);
            ListNode right = mergeSort(midNext);
            return merge(left, right);
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
            tail.next = left == null ? right : left;
            return dummy.next;
        }

        private ListNode findMid(ListNode head) {
            ListNode fast = head, slow = head;
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
