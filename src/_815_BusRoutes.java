import java.util.*;

public class _815_BusRoutes {
    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if(source == target) {
                return 0;
            }
            int n = routes.length;
            Map<Integer, List<Integer>> stopToBus = new HashMap<>();
            for(int i = 0; i < n; i++) {
                for(int route : routes[i]) {
                    stopToBus.putIfAbsent(route, new ArrayList<>());
                    stopToBus.get(route).add(i);
                }
            }
            Queue<Integer> queue = new ArrayDeque<>();
            Map<Integer, Integer> map = new HashMap<>();
            for(int bus : stopToBus.get(source)) {
                queue.offer(bus);
                map.put(bus, 1);
            }

            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int stop : routes[cur]) {
                    if(stop == target) {
                        return map.get(cur);
                    }
                    for(int bus : stopToBus.get(stop)) {
                        if(map.containsKey(bus)) {
                            continue;
                        }
                        map.put(bus, map.get(cur) + 1);
                        queue.offer(bus);
                    }
                }
            }
            return -1;
        }
    }
}
