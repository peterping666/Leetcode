import java.util.*;

public class _347_TopKFrequentElements {
    /**
     * Time O(nlogk)
     * Space O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
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
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int size = Collections.max(freq.values());
        List<Integer>[] list = new List[size + 1];
        for(int num : freq.keySet()) {
            if(list[freq.get(num)] == null) {
                list[freq.get(num)] = new ArrayList<>();
            }
            list[freq.get(num)].add(num);
        }
        int[] ans = new int[k];
        int index = ans.length - 1;
        for(int i = list.length - 1; i >= 0; i--) {
            if(list[i] == null) continue;
            for(int j = 0; j < list[i].size(); j++) {
                ans[index--] = list[i].get(j);
                if(index < 0) return ans;
            }
        }
        return ans;
    }
}
