public class _1769_MinimumNumberofOperationstoMoveAllBallstoEachBox {
    class Solution {
        public int[] minOperations(String boxes) {
            int n = boxes.length();
            int[] left = new int[n];
            int[] right = new int[n];
            int balls = 0, move = 0;
            for(int i = 0; i < n; i++) {
                move += balls;
                left[i] = move;
                if(boxes.charAt(i) == '1') {
                    balls++;
                }
            }
            balls = 0;
            move = 0;
            for(int i = n-1; i >= 0; i--) {
                move += balls;
                right[i] = move;
                if(boxes.charAt(i) == '1') {
                    balls++;
                }
            }
            int[] res = new int[n];
            for(int i = 0; i < n; i++) {
                res[i] = left[i] + right[i];
            }
            return res;
        }
    }
}
