public class _24_SwapNodesinPairs {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode newHead = head.next;
            ListNode nextHead = newHead.next;
            newHead.next = head;
            head.next = swapPairs(nextHead);
            return newHead;
        }
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }
}
