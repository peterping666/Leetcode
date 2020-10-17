package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _404_FactorCombinations {
    public class Solution {
        public List<List<Integer>> combinations(int target) {
            List<List<Integer>> result = new ArrayList<>();
            helper(result, new ArrayList<>(), target, 2);
            return result;
        }

        private void helper(List<List<Integer>> result, List<Integer> path, int target, int start) {
            for(int i = start; i <= Math.sqrt(target); i++) {
                if(target % i == 0) {
                    path.add(i);
                    path.add(target / i);
                    result.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                    helper(result, path, target / i, i);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

}
