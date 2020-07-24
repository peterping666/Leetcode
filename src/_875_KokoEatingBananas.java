public class _875_KokoEatingBananas {
    class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            int max = 0;
            for(int pile : piles) {
                max = Math.max(pile, max);
            }
            int left = 1;
            int right = max;
            while(left < right) {
                int mid = left + (right - left) / 2;
                int h = 0;
                for(int pile : piles) {
                    h += (pile % mid == 0 ? pile / mid : pile / mid + 1);
                }
                if(h > H) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
