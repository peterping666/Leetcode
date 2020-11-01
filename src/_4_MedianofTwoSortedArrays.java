public class _4_MedianofTwoSortedArrays {
    /**
     * Time O(log(min(m,n)))
     * Space O(log(min(m,n)))
     */
    class Solution1 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            if(len % 2 == 1) {
                return kth(nums1, 0, nums2, 0, len / 2 + 1);
            }
            return (kth(nums1, 0, nums2, 0, len / 2) + kth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }

        private int kth(int[] a, int astart, int[] b, int bstart, int k) {
            if(astart >= a.length) {
                return b[bstart + k - 1];
            }
            if(bstart >= b.length) {
                return a[astart + k - 1];
            }
            if(k == 1) {
                return Math.min(a[astart], b[bstart]);
            }
            int amid = astart + k / 2 - 1;
            int bmid = bstart + k / 2 - 1;
            int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
            int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];

            if(aval <= bval) {
                return kth(a, amid + 1, b, bstart, k - k / 2);
            } else {
                return kth(a, astart, b, bmid + 1, k - k / 2);
            }
        }
    }

    /**
     * Time O(m + n)
     * Space O(m + n)
     */
    class Solution2 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] mergedArray = merge(nums1, nums2);
            int len = nums1.length + nums2.length;
            if(len % 2 == 1) {
                return mergedArray[len / 2];
            }
            return (mergedArray[len / 2 - 1] + mergedArray[len / 2]) / 2.0;
        }

        private int[] merge(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int[] array = new int[m + n];
            int index = 0;
            int i = 0;
            int j = 0;
            while(i < n && j < m) {
                if(nums1[i] < nums2[j]) {
                    array[index++] = nums1[i++];
                } else {
                    array[index++] = nums2[j++];
                }
            }
            while(i < n) {
                array[index++] = nums1[i++];
            }
            while(j < m) {
                array[index++] = nums2[j++];
            }
            return array;
        }
    }
}
