import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1636_SortArraybyIncreasingFrequency {
    class Solution1 {
        public int[] frequencySort(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                    (a,b) -> a.getValue() == b.getValue() ?
                            Integer.compare(b.getKey(), a.getKey()) :
                            Integer.compare(a.getValue(), b.getValue())
            );
            for(int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                heap.offer(entry);
            }
            int index = 0;
            while(!heap.isEmpty()) {
                Map.Entry<Integer, Integer> entry = heap.poll();
                int num = entry.getKey();
                int freq = entry.getValue();
                while(freq-- > 0) {
                    nums[index++] = num;
                }
            }
            return nums;
        }
    }

    class Solution2 {
        public int[] frequencySort(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            Queue<Integer> heap = new PriorityQueue<>(
                    (a,b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a).compareTo(map.get(b))
            );
            for(int num : nums) {
                if(map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }

            for(Integer key : map.keySet()) {
                heap.offer(key);
            }

            int index = 0;
            while(!heap.isEmpty()) {
                int num = heap.poll();
                int freq = map.get(num);
                while(freq-- > 0) {
                    nums[index++] = num;
                }
            }
            return nums;
        }
    }
}
