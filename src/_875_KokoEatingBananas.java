public class _875_KokoEatingBananas {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1, right = 0;
            for(int p : piles) {
                right = Math.max(right, p);
            }
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(valid(piles, h, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean valid(int[] piles, int h, int eat) {
            for(int pile : piles) {
                h -= pile / eat + (pile % eat == 0 ? 0 : 1);
                if(h < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
