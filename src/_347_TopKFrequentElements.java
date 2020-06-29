import java.util.*;

public class _347_TopKFrequentElements {
    /**
     * Time O(nlogk)
     * Space O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    /**
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
        List<Integer>[] lists = new List[nums.length + 1];
        for(int key : map.keySet()) {
            int freq = map.get(key);
            if(lists[freq] == null) {
                lists[freq] = new ArrayList<>();
            }
            lists[freq].add(key);
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i = lists.length - 1; i >= 0; i--) {
            if(lists[i] != null) {
                List<Integer> list = lists[i];
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
