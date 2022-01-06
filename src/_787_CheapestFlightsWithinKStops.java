import java.util.*;

public class _787_CheapestFlightsWithinKStops {

    /**
     * Time O(nlogn + Elogn)
     */
    class Solution1 {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
            for(int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                graph.putIfAbsent(from, new HashMap<>());
                graph.get(from).put(to, price);
            }
            Map<Integer, Integer> seen = new HashMap<>();
            Queue<Node> heap = new PriorityQueue<>((a,b) -> Integer.compare(a.cost, b.cost));
            heap.offer(new Node(src, 0, 0));
            while(!heap.isEmpty()) {
                Node cur = heap.poll();
                if(seen.containsKey(cur.city) && cur.stop >= seen.get(cur.city)) {
                    continue;
                }
                seen.put(cur.city, cur.stop);
                if(cur.city == dst) {
                    return cur.cost;
                }
                if(cur.stop > k) {
                    continue;
                }
                if(!graph.containsKey(cur.city)) {
                    continue;
                }
                seen.put(cur.city, cur.stop);
                Map<Integer, Integer> map = graph.get(cur.city);
                for(int next : map.keySet()) {
                    heap.offer(new Node(next, cur.cost + map.get(next), cur.stop + 1));
                }
            }
            return -1;
        }

        class Node {
            int city;
            int cost;
            int stop;

            Node(int city, int cost, int stop) {
                this.city = city;
                this.cost = cost;
                this.stop = stop;
            }
        }
    }

    /**
     * Time O(nk)
     */
    class Solution2 {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[][] dp = new int[k+2][n];
            for(int[] arr : dp) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
            for(int i = 0; i <= k+1; i++) {
                dp[i][src] = 0;
            }
            for(int i = 1; i <= k+1; i++) {
                for(int[] flight : flights) {
                    int from = flight[0];
                    int to = flight[1];
                    int price = flight[2];

                    if(dp[i-1][from] != Integer.MAX_VALUE) {
                        dp[i][to] = Math.min(dp[i][to], dp[i-1][from] + price);
                    }
                }
            }
            return dp[k+1][dst] == Integer.MAX_VALUE ? -1 : dp[k+1][dst];
        }
    }
}
