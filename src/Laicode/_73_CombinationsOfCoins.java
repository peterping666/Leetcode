package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _73_CombinationsOfCoins {
    public class Solution {
        public List<List<Integer>> combinations(int target, int[] coins) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, target, 0, coins, new ArrayList<>());
            return res;
        }

        private void helper(List<List<Integer>> res, int target, int index, int[] coins, List<Integer> path) {

            if(index == coins.length - 1) {
                if(target % coins[index] == 0) {
                    path.add(target / coins[index]);
                    res.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                }
                return;
            }

            int size = target / coins[index];
            for(int i = 0; i <= size; i++) {
                path.add(i);
                helper(res, target - coins[index] * i, index + 1, coins, path);
                path.remove(path.size() - 1);
            }
        }
    }

}
