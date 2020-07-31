package Laicode;

import java.util.*;

public class _67_TopKFrequentWords {
    public class Solution {
        public String[] topKFrequent(String[] combo, int k) {
            if(combo == null || combo.length == 0) {
                return new String[0];
            }
            Map<String, Integer> map = new HashMap<>();
            for(String s : combo) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            Queue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
                    new Comparator<Map.Entry<String, Integer>>() {
                        @Override
                        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                            return e1.getValue().compareTo(e2.getValue());
                        }
                    });
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(heap.size() < k) {
                    heap.offer(entry);
                } else if(heap.peek().getValue() < entry.getValue()) {
                    heap.poll();
                    heap.offer(entry);
                }
            }
            String[] res = new String[heap.size()];
            for(int i = heap.size() - 1; i >= 0; i--) {
                res[i] = heap.poll().getKey();
            }
            return res;
        }
    }

}
