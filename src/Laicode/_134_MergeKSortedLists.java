package Laicode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _134_MergeKSortedLists {
    public class Solution {
        public ListNode merge(List<ListNode> listOfLists) {
            Queue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode a, ListNode b) {
                    if(a.value == b.value) {
                        return 0;
                    }
                    return a.value < b.value ? -1 : 1;
                }
            });
            for(ListNode node : listOfLists) {
                if(node != null) {
                    minHeap.offer(node);
                }
            }
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while(!minHeap.isEmpty()) {
                ListNode cur = minHeap.poll();
                tail.next = cur;
                tail = tail.next;
                if(cur.next != null) {
                    minHeap.offer(cur.next);
                }
            }
            return dummy.next;
        }
    }
}
