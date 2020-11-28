public class _445_AddTwoNumbersII {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode rev1 = reverse(l1);
            ListNode rev2 = reverse(l2);
            ListNode head = merge(rev1, rev2);
            return reverse(head);
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            int sum = 0;
            while(l1 != null || l2 != null) {
                if(l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if(l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
                sum /= 10;
            }
            if(sum != 0) {
                tail.next = new ListNode(sum);
            }
            return dummy.next;
        }

        private ListNode reverse(ListNode node) {
            ListNode prev = null;
            while(node != null) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
            return prev;
        }
    }
}
