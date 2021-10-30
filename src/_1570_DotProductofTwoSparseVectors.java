public class _1570_DotProductofTwoSparseVectors {
    class SparseVector {
        int[] arr;
        SparseVector(int[] nums) {
            arr = nums;
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int sum = 0;
            for(int i = 0; i < arr.length; i++) {
                sum += arr[i]*vec.arr[i];
            }
            return sum;
        }
    }

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
}
