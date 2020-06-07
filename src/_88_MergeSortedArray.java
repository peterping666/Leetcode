public class _88_MergeSortedArray {

    /**
     * Time O(n)
     * Space O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right = nums1.length - 1;
        m--;
        n--;
        while(m >=0 && n >= 0) {
            if(nums1[m] > nums2[n]) {
                nums1[right--] = nums1[m--];
            } else {
                nums1[right--] = nums2[n--];
            }
        }

        while(n >= 0) {
            nums1[right--] = nums2[n--];
        }
    }
}
