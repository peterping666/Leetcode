import java.util.Arrays;

public class _462_MinimumMovesEqualArrayElements2 {
    /**
     * Time O(nlogn)
     * Space O(1)
     */
    public int minMoves1(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int moves = 0;
        while(left < right) {
            moves += nums[right--] - nums[left++];
        }
        return moves;
    }

    /**
     * Time O(n) worst O(n^2)
     * Space O(1)
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        int sum = 0;
        int median = kthSmallest(nums, 0, nums.length - 1, nums.length / 2 + 1);
        for (int num : nums) {
            sum += Math.abs(median - num);
        }
        return sum;
    }
    public void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    public int partition(int[] list, int left, int right, int val) {
        int i;
        for (i = left; i < right; i++) {
            if (list[i] == val) {
                break;
            }
        }
        swap(list, i, right);
        int pivotValue = list[right];
        int storeIndex = left;
        for (i = left; i <= right; i++) {
            if (list[i] < pivotValue) {
                swap(list, storeIndex, i);
                storeIndex++;
            }
        }
        swap(list, right, storeIndex);
        return storeIndex;
    }
    int findMedian(int arr[], int l, int len) {
        Arrays.sort(arr, l, l + len);
        return arr[l + len / 2];
    }
    int kthSmallest(int arr[], int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            int n = r - l + 1, i;
            int median[] = new int[(n + 4) / 5];
            for (i = 0; i < n / 5; i++) {
                median[i] = findMedian(arr, l + i * 5, 5);
            }
            if (i * 5 < n) {
                median[i] = findMedian(arr, l + i * 5, n % 5);
                i++;
            }
            int medOfMed = (i == 1) ? median[i - 1]: kthSmallest(median, 0, i - 1, i / 2);

            int pos = partition(arr, l, r, medOfMed);
            if (pos - l == k - 1) {
                return arr[pos];
            }
            if (pos - l > k - 1) {
                return kthSmallest(arr, l, pos - 1, k);
            }
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }
        return Integer.MAX_VALUE;
    }
}
