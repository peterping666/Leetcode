public class _445_AddTwoNumbersII {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverse(l1);
            l2 = reverse(l2);
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            int num = 0;
            while(l1 != null || l2 != null) {
                if(l1 != null) {
                    num += l1.val;
                    l1 = l1.next;
                }
                if(l2 != null) {
                    num += l2.val;
                    l2 = l2.next;
                }
                tail.next = new ListNode(num % 10);
                tail = tail.next;
                num /= 10;
            }
            if(num != 0) {
                tail.next = new ListNode(num);
            }
            return reverse(dummy.next);
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null;
            while(head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
}
