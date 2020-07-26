public class _445_AddTwoNumbersII {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverse(l1);
            l2 = reverse(l2);
            int carry = 0;
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while(l1 != null || l2 != null) {
                int num1 = 0;
                if(l1 != null) {
                    num1 = l1.val;
                    l1 = l1.next;
                }
                int num2 = 0;
                if(l2 != null) {
                    num2 = l2.val;
                    l2 = l2.next;
                }
                int sum = num1 + num2 + carry;
                carry = sum / 10;
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            if(carry != 0) {
                tail.next = new ListNode(carry);
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
