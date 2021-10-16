public class _441_ArrangingCoins {
    class Solution1 {
        public int arrangeCoins(int n) {
            int i=0;
            while(n > 0){
                i+=1;
                n-=i;
            }

            return n==0 ? i : i-1;
        }
    }

    class Solution2 {
        public int arrangeCoins(int n) {
            return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
        }
    }
}
