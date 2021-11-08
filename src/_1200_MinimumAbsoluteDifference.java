import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1200_MinimumAbsoluteDifference {
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            List<List<Integer>> res = new ArrayList<>();
            int minDiff = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length - 1; i++) {
                int diff = arr[i+1] - arr[i];
                if(diff < minDiff) {
                    minDiff = diff;
                    res.clear();
                    res.add(Arrays.asList(arr[i], arr[i+1]));
                } else if(diff == minDiff) {
                    res.add(Arrays.asList(arr[i], arr[i+1]));
                }
            }
            return res;
        }
    }
}
