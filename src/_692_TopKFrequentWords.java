import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class _692_TopKFrequentWords {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap<>();
            for(String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<String> heap = new PriorityQueue<>(
                    (a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));
            for(String word : map.keySet()) {
                heap.offer(word);
                if(heap.size() > k) {
                    heap.poll();
                }
            }
            List<String> res = new LinkedList<>();
            while(!heap.isEmpty()) {
                res.add(0, heap.poll());
            }
            return res;
        }
    }
}
