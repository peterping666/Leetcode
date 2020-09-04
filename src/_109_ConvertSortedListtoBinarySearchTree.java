public class _109_ConvertSortedListtoBinarySearchTree {
    /**
     * Time O(n)
     * space O(logn)
     * @return
     */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return helper(head, null);
        }

        private TreeNode helper(ListNode head, ListNode tail) {
            if(head == tail) {
                return null;
            }
            ListNode mid = findMid(head, tail);
            TreeNode root = new TreeNode(mid.val);
            root.left = helper(head, mid);
            root.right = helper(mid.next, tail);
            return root;
        }

        private ListNode findMid(ListNode head, ListNode tail) {
            ListNode slow = head;
            ListNode fast = head;
            while(fast != tail && fast.next != tail) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
