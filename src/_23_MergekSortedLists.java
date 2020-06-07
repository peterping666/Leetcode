import java.util.PriorityQueue;

public class _23_MergekSortedLists {
    /**
     * Time O(nlogk)
     * Space O(k)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node : lists) {
            if(node != null) heap.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!heap.isEmpty()) {
            cur.next = heap.poll();
            cur = cur.next;
            if(cur.next != null) {
                heap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
