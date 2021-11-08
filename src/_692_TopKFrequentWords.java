import java.util.*;

public class _692_TopKFrequentWords {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < words.length; i++) {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
            Queue<Map.Entry<String, Integer>> heap = new PriorityQueue<>((a,b) -> {
                if(a.getValue() == b.getValue()) {
                    return b.getKey().compareTo(a.getKey());
                }
                return a.getValue().compareTo(b.getValue());
            });
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                heap.offer(entry);
                if(heap.size() > k) {
                    heap.poll();
                }
            }
            List<String> res = new LinkedList<>();
            while(!heap.isEmpty()) {
                res.add(0, heap.poll().getKey());
            }
            return res;
        }
    }
}
