public class _164_MaximumGap {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public int maximumGap(int[] nums) {
            int n = nums.length;
            if(n == 1) {
                return 0;
            }
            if(n == 2) {
                return nums[1] - nums[0];
            }
            Bucket[] buckets = new Bucket[n-1];
            for(int i = 0; i < n-1; i++) {
                buckets[i] = new Bucket();
            }
            int min = nums[0], max = nums[0];
            for(int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            if(max == min) {
                return 0;
            }
            for(int i = 0; i < n; i++) {
                int idx = findIndex(nums[i], max, min, n-1);
                buckets[idx].update(nums[i]);
            }
            int res = 0, prevMax = min;
            for(Bucket bucket : buckets) {
                if(bucket.isEmpty) {
                    continue;
                }
                res = Math.max(res, bucket.min - prevMax);
                prevMax = bucket.max;
            }
            return res;
        }

        private int findIndex(int num, int max, int min, int n) {
            double size = (double)(max - min) / n;
            return (int)Math.min(n-1, (num - min) / size);
        }

        class Bucket {
            int min;
            int max;
            boolean isEmpty;

            Bucket() {
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                isEmpty = true;
            }

            void update(int val) {
                min = Math.min(min, val);
                max = Math.max(max, val);
                isEmpty = false;
            }
        }
    }
}
