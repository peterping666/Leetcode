import java.util.PriorityQueue;
import java.util.Queue;

public class _23_MergekSortedLists {
    /**
     * Use minHeap
     * Time: O(nlogk)
     * Space: O(k)
     */
    class Solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
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

    /**
     * Use merge sort
     * Time: O(nlogk) k is length of lists
     * Space: O(1) on heap, and O(logk) on stack because of recursive function call
     */
    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0) {
                return null;
            }
            return mergeSort(lists, 0, lists.length - 1);
        }

        private ListNode mergeSort(ListNode[] lists, int left, int right) {
            if(left == right) {
                return lists[left];
            }
            int mid = left + (right - left) / 2;
            ListNode l1 = mergeSort(lists, left, mid);
            ListNode l2 = mergeSort(lists, mid + 1, right);
            return merge(l1, l2);
        }

        public ListNode merge(ListNode l1, ListNode l2){
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
            if(l1 != null) {
                tail.next = l1;
            } else {
                tail.next = l2;
            }
            return dummy.next;
        }
    }
}
