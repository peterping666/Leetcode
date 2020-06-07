import java.util.*;

public class _215_KthLargestElementinArray {
    /**
     * Time O(nlogk)
     * Space O(k)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums) {
            heap.offer(num);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }


    /**
     * Time Avg O(n) Worst O(n^2)
     * Space O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int p = partition(nums, left, right);
            if(p + 1 == k) {
                return nums[p];
            }
            if(p + 1 < k) {
                left = p + 1;
            } else {
                right = p - 1;
            }
        }
        return nums[left];
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int start = left + 1;
        int end = right;
        while(start <= end) {
            if(nums[start] <= pivot && nums[end] > pivot) {
                swap(nums, start++, end--);
            }
            if(nums[start] > pivot) {
                start++;
            }
            if(nums[end] <= pivot) {
                end--;
            }
        }
        swap(nums, left, end);
        return end;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
