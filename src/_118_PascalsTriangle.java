import java.util.*;

public class _118_PascalsTriangle {

    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            res.add(new ArrayList<>());
            res.get(0).add(1);
            for(int i = 1; i < numRows; i++) {
                res.add(new ArrayList<>());
                for(int j = 0; j < i+1; j++) {
                    int left = j == 0 ? 0 : res.get(i-1).get(j-1);
                    int right = j == i ? 0 : res.get(i-1).get(j);
                    res.get(i).add(left + right);
                }
            }
            return res;
        }
    }
}
