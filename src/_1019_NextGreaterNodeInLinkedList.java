import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _1019_NextGreaterNodeInLinkedList {

    class Solution1 {
        public int[] nextLargerNodes(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while(head != null) {
                list.add(head.val);
                head = head.next;
            }
            int n = list.size();
            int[] res = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                while(!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                    res[stack.poll()] = list.get(i);
                }
                stack.push(i);
            }
            return res;
        }
    }

    class Solution2 {
        public int[] nextLargerNodes(ListNode head) {
            int n = getLen(head);
            int[] res = new int[n];
            Deque<int[]> stack = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                int cur = head.val;
                while(!stack.isEmpty() && stack.peek()[0] < cur) {
                    res[stack.poll()[1]] = cur;
                }
                stack.push(new int[]{cur, i});
                head = head.next;
            }
            return res;
        }

        private int getLen(ListNode head) {
            int res = 0;
            while(head != null) {
                head = head.next;
                res++;
            }
            return res;
        }
    }
}
