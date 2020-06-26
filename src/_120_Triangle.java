import java.util.List;

public class _120_Triangle {
    /**
     * Time O(n^2)
     * Space O(n)
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] sums = new int[n + 1];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                sums[j] = Math.min(sums[j], sums[j + 1]) + triangle.get(i).get(j);
            }
        }
        return sums[0];
    }
}
