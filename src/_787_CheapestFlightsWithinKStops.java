import java.util.Arrays;
import java.util.PriorityQueue;

public class _787_CheapestFlightsWithinKStops {
    class Solution1 {
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

    class Solution2 {

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            // Build the adjacency matrix
            int adjMatrix[][] = new int[n][n];
            for (int[] flight: flights) {
                adjMatrix[flight[0]][flight[1]] = flight[2];
            }

            // Shortest distances array
            int[] distances = new int[n];

            // Shortest steps array
            int[] currentStops = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            Arrays.fill(currentStops, Integer.MAX_VALUE);
            distances[src] = 0;
            currentStops[src] = 0;

            // The priority queue would contain (node, cost, stops)
            PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
            minHeap.offer(new int[]{src, 0, 0});

            while (!minHeap.isEmpty()) {

                int[] info = minHeap.poll();
                int node = info[0], stops = info[2], cost = info[1];

                // If destination is reached, return the cost to get here
                if (node == dst) {
                    return cost;
                }

                // If there are no more steps left, continue
                if (stops == K + 1) {
                    continue;
                }

                // Examine and relax all neighboring edges if possible
                for (int nei = 0; nei < n; nei++) {
                    if (adjMatrix[node][nei] > 0) {
                        int dU = cost, dV = distances[nei], wUV = adjMatrix[node][nei];

                        // Better cost?
                        if (dU + wUV < dV) {
                            minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                            distances[nei] = dU + wUV;
                        }
                        else if (stops < currentStops[nei]) {
                            minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        }
                        currentStops[nei] = stops;
                    }
                }
            }

            return distances[dst] == Integer.MAX_VALUE? -1 : distances[dst];
        }
    }
}
