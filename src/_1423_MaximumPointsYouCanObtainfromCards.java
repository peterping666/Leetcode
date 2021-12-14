public class _1423_MaximumPointsYouCanObtainfromCards {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length, lsum = 0;
            for(int i = 0; i < k; i++) {
                lsum += cardPoints[i];
            }
            int res = lsum;
            for(int i = 0, rsum = 0; i < k; i++) {
                rsum += cardPoints[n-i-1];
                lsum -= cardPoints[k-i-1];
                res = Math.max(res, lsum + rsum);
            }
            return res;
        }
    }
}
