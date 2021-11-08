import java.util.HashMap;
import java.util.Map;

public class _1570_DotProductofTwoSparseVectors {
    class SparseVector {

        Map<Integer, Integer> map;

        SparseVector(int[] nums) {
            map = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != 0) {
                    map.put(i, nums[i]);
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            if (vec.map.size() < this.map.size()) {
                return vec.dotProduct(this);
            }
            int result = 0;
            for (Integer currIdx : this.map.keySet()) {
                if (vec.map.containsKey(currIdx)) {
                    result += this.map.get(currIdx) * vec.map.get(currIdx);
                }
            }
            return result;
        }
    }

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
}
