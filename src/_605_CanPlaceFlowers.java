public class _605_CanPlaceFlowers {
    class Solution1 {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if(n == 0) {
                return true;
            }
            for(int i = 0; i < flowerbed.length; i++) {
                if(flowerbed[i] == 1 || i != 0 && flowerbed[i-1] == 1 || i != flowerbed.length - 1 && flowerbed[i+1] == 1) {
                    continue;
                }
                i++;
                if(--n == 0) {
                    return true;
                }
            }
            return false;
        }
    }

    class Solution2 {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int count = 0;
            for(int i = 0; i < flowerbed.length && count < n; i++) {
                if(flowerbed[i] == 0) {
                    int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                    int prev = (i == 0) ? 0 : flowerbed[i - 1];
                    if(next == 0 && prev == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                }
            }

            return count == n;
        }
    }
}
