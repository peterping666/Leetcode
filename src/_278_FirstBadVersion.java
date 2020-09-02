public class _278_FirstBadVersion {
    public class Solution {
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(!isBadVersion(mid)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

    boolean isBadVersion(int version){return true;}
}
