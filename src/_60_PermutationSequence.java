import java.util.ArrayList;
import java.util.List;

public class _60_PermutationSequence {
    /**
     * Time O(n)
     * Space O(n)
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
            list.add(i);
        }
        list.add(n);
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i--) {
            int idx = k / fact[i];
            k %= fact[i];
            sb.append(list.get(idx));
            list.remove(idx);
        }
        return sb.toString();
    }
}
