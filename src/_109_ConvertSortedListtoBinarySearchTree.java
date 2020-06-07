public class _109_ConvertSortedListtoBinarySearchTree {
    /**
     * Time O(n)
     * space O(logn)
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if(head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != tail && fast.next.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = helper(head, slow);
        node.right = helper(slow.next, tail);
        return node;
    }
}
