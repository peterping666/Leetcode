import java.util.*;

public class _853_CarFleet {

    class Solution1 {
        public int carFleet(int target, int[] position, int[] speed) {
            List<int[]> list = new ArrayList<>();
            for(int i = 0; i < speed.length; i++) {
                list.add(new int[]{position[i], speed[i]});
            }
            Collections.sort(list, (a, b) -> Integer.compare(b[0], a[0]));
            double max = Double.MIN_VALUE;
            int res = 0;
            for(int[] arr : list) {
                double time = (double)(target - arr[0]) / arr[1];
                if(time > max) {
                    res++;
                    max = time;
                }
            }
            return res;
        }
    }

    class Solution2 {
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            Map<Integer, Double> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                map.put(position[i], (target - position[i]) / (double) speed[i]);
            }
            Arrays.sort(position);
            int res = 0;
            double maxTime = 0;
            for(int i = n - 1; i >= 0; i--) {
                if(map.get(position[i]) > maxTime) {
                    res++;
                    maxTime = map.get(position[i]);
                }
            }
            return res;
        }
    }
}
