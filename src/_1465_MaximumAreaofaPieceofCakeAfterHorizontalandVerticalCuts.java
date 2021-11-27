import java.util.Arrays;

public class _1465_MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts {
    class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            int m = horizontalCuts.length;
            int n = verticalCuts.length;
            Arrays.sort(horizontalCuts);
            Arrays.sort(verticalCuts);

            int maxH = horizontalCuts[0];
            for (int i = 1; i < m; i++) {
                maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
            }
            maxH = Math.max(maxH, h - horizontalCuts[m - 1]);

            int maxV = verticalCuts[0];
            for (int i = 1; i < n; i++) {
                maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i - 1]);
            }
            maxV = Math.max(maxV, w - verticalCuts[n- 1]);

            int mod = (int)(1e9+7);

            return (int)((long)maxH * maxV % mod);
        }
    }
}
