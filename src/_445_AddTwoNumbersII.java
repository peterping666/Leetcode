import java.util.ArrayDeque;
import java.util.Deque;

public class _445_AddTwoNumbersII {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<Integer> stack1 = new ArrayDeque<>();
            Deque<Integer> stack2 = new ArrayDeque<>();
            while(l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while(l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
            ListNode dummy = new ListNode(0);
            int sum = 0;
            while(!stack1.isEmpty() || !stack2.isEmpty()) {
                if(!stack1.isEmpty()) {
                    sum += stack1.pop();
                }
                if(!stack2.isEmpty()) {
                    sum += stack2.pop();
                }
                ListNode newNode = new ListNode(sum % 10);
                newNode.next = dummy.next;
                dummy.next = newNode;
                sum /= 10;
            }
            if(sum != 0) {
                dummy.val = sum;
            }
            return dummy.val == 0 ? dummy.next : dummy;
        }
    }
}
