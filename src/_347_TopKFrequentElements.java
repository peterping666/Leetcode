import java.util.*;

public class _347_TopKFrequentElements {
    /**
     * Time O(nlogk)
     * Space O(n)
     * @return
     */
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequency = new HashMap<>();
            for(int num : nums) {
                frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            }
            int[] result = new int[k];
            Queue<Map.Entry<Integer, Integer>> minHeap =
                    new PriorityQueue<>((a, b) -> a.getValue().compareTo(b.getValue()));
            for(Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
                if(minHeap.size() < k) {
                    minHeap.offer(entry);
                } else if(minHeap.peek().getValue() < entry.getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
            for(int i = k - 1; i >= 0; i--) {
                result[i] = minHeap.poll().getKey();
            }
            return result;
        }
    }

    /**
     * Bucket sort
     * Time O(n)
     * Space O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key : map.keySet()) {
            int freq = map.get(key);
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i = bucket.length - 1; i >= 0; i--) {
            if(bucket[i] != null) {
                List<Integer> list = bucket[i];
                for(int num : list) {
                    res[idx++] = num;
                    if(idx == k) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
