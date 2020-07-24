import java.util.*;

public class _815_BusRoutes {
    class Solution {
        public int numBusesToDestination(int[][] routes, int S, int T) {
            HashMap<Integer, List<Integer>> buses = new HashMap<>();
            for(int i = 0; i < routes.length; i++) {
                for(int stop : routes[i]) {
                    buses.putIfAbsent(stop, new ArrayList<>());
                    buses.get(stop).add(i);
                }
            }
            HashSet<Integer> seen = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            if(S == T) {
                return 0;
            }
            q.offer(S);
            int res = 0;
            while(!q.isEmpty()) {
                res++;
                for(int i = q.size(); i > 0; i--) {
                    int cur = q.poll();
                    for(int bus : buses.get(cur)) {
                        if(seen.add(bus)) {
                            for(int stop : routes[bus]) {
                                if(stop == T) {
                                    return res;
                                }
                                q.offer(stop);
                            }
                        }
                    }
                }
            }
            return -1;
        }
    }
}
