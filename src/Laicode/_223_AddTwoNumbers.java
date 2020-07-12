package Laicode;

public class _223_AddTwoNumbers {
    /**
     * class ListNode {
     *   public int value;
     *   public ListNode next;
     *   public ListNode(int value) {
     *     this.value = value;
     *     next = null;
     *   }
     * }
     */
    public class Solution {
        public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
            // Write your solution here
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            int val = 0;
            while(l1 != null || l2 != null || val != 0) {
                if(l1 != null) {
                    val += l1.value;
                    l1 = l1.next;
                }
                if(l2 != null) {
                    val += l2.value;
                    l2 = l2.next;
                }
                tail.next = new ListNode(val % 10);
                val /= 10;
                tail = tail.next;
            }
            return dummy.next;
        }

        /**
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            // Write your solution here
            ListNode one = reverse(l1);
            ListNode two = reverse(l2);
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            int carry = 0;
            while(one != null || two != null) {
                int val1 = one == null ? 0 : one.value;
                int val2 = two == null ? 0 : two.value;
                int sum = val1 + val2 + carry;
                ListNode newNode = new ListNode(sum % 10);
                carry = sum / 10;
                tail.next = newNode;
                tail = tail.next;
                if(one != null) {
                    one = one.next;
                }
                if(two != null) {
                    two = two.next;
                }
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
