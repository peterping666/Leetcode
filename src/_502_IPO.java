import java.util.PriorityQueue;

public class _502_IPO {
    /**
     * Time O(nlogn)
     * Space O(n)
     * @param k
     * @param W
     * @param Profits
     * @param Capital
     * @return
     */
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> capitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> profitHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < Profits.length; i++) {
            capitalHeap.offer(new int[]{Capital[i], Profits[i]});
        }
        for(int i = 0; i < k; i++) {
            while(!capitalHeap.isEmpty() && capitalHeap.peek()[0] <= W) {
                profitHeap.offer(capitalHeap.poll());
            }
            if(profitHeap.isEmpty()) break;
            W += profitHeap.poll()[1];
        }
        return W;
    }
}
