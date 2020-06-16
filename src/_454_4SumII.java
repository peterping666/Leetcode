import java.util.HashMap;

public class _454_4SumII {
    /**
     * Time O(n^2)
     * Space O(n^2)
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : A) {
            for(int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        for(int c : C) {
            for(int d : D) {
                count += map.getOrDefault(-c - d, 0);
            }
        }
        return count;
    }
}
