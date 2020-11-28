import java.util.Arrays;

public class _1029_TwoCityScheduling {
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            int[] refund = new int[costs.length];
            int total = 0;
            for(int i = 0; i < costs.length; i++) {
                total += costs[i][0];
                refund[i] = costs[i][1] - costs[i][0];
            }
            Arrays.sort(refund);
            for(int i = 0; i < refund.length / 2; i++) {
                total += refund[i];
            }
            return total;
        }
    }
}
