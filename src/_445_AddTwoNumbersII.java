import java.util.ArrayDeque;
import java.util.Deque;

public class _445_AddTwoNumbersII {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<Integer> stack1 = new ArrayDeque<>();
            Deque<Integer> stack2 = new ArrayDeque<>();
            while(l1 != null) {
                stack1.offerFirst(l1.val);
                l1 = l1.next;
            }
            while(l2 != null) {
                stack2.offerFirst(l2.val);
                l2 = l2.next;
            }

            int sum = 0;
            ListNode list = new ListNode(0);
            while(!stack1.isEmpty() || !stack2.isEmpty()) {
                if(!stack1.isEmpty()) {
                    sum += stack1.pollFirst();
                }
                if(!stack2.isEmpty()) {
                    sum += stack2.pollFirst();
                }
                list.val = sum % 10;
                ListNode head = new ListNode(sum / 10);
                head.next = list;
                list = head;
                sum /= 10;
            }
            return list.val == 0 ? list.next : list;
        }
    }
}
