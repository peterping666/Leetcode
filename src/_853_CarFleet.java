import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _853_CarFleet {
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            Map<Integer, Double> map = new HashMap<>();
            for(int i = 0; i < position.length; i++) {
                map.put(position[i], (target - position[i]) / (double) speed[i]);
            }
            Arrays.sort(position);
            int res = 0;
            double maxTime = 0;
            for(int i = position.length - 1; i >= 0; i--) {
                if(map.get(position[i]) > maxTime) {
                    res++;
                    maxTime = map.get(position[i]);
                }
            }
            return res;
        }
    }
}
