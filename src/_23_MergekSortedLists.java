import java.util.PriorityQueue;
import java.util.Queue;

public class _23_MergekSortedLists {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> {
                if(a.val == b.val) {
                    return 0;
                }
                return a.val < b.val ? -1 : 1;
            });
            for(ListNode node : lists) {
                if(node != null) {
                    minHeap.offer(node);
                }
            }
            while(!minHeap.isEmpty()) {
                tail.next = minHeap.poll();
                tail = tail.next;
                if(tail.next != null) {
                    minHeap.offer(tail.next);
                }
            }
            return dummy.next;
        }
    }
}
