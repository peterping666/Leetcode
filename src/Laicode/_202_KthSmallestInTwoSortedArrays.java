package Laicode;

public class _202_KthSmallestInTwoSortedArrays {
    /**
     * Iteration
     */
    public class Solution1 {
        public int kth(int[] a, int[] b, int k) {
            int len1 = a.length;
            int len2 = b.length;
            if (len1 > len2) return kth(b, a, k);
            int lo = k > len2 ? k - len2 : 0;
            int hi = len1 < k ? len1 : k;
            while (lo < hi){
                int mid1 = lo + (hi - lo)/2;
                int mid2 = k - 1 - mid1;
                if (a[mid1] <= b[mid2]){
                    lo = mid1 + 1;
                }
                else{
                    hi = mid1;
                }
            }
            if (hi == 0) return b[k-1];
            else if (hi == k) return a[k-1];
            else return a[hi-1] <= b[k-hi-1] ? b[k-hi-1] : a[hi-1];
        }
    }

    /**
     * Recursion
     */
    public class Solution2 {
        public int kth(int[] a, int[] b, int k) {
            return kth(a, 0, b, 0, k);
        }

        private int kth(int[] a, int aleft, int[] b, int bleft, int k) {
            if(aleft >= a.length) {
                return b[bleft + k - 1];
            }
            if(bleft >= b.length) {
                return a[aleft + k - 1];
            }
            if(k == 1) {
                return Math.min(a[aleft], b[bleft]);
            }

            int amid = aleft + k/2 - 1;
            int bmid = bleft + k/2 - 1;
            int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
            int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
            if(aval <= bval) {
                return kth(a, amid + 1, b, bleft, k - k / 2);
            } else {
                return kth(a, aleft, b, bmid + 1, k - k / 2);
            }
        }
    }

}
