import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class _403_FrogJump {
    class Solution {
        public boolean canCross(int[] stones) {
            Set<Integer> set = new HashSet<>();
            for(int stone : stones) {
                set.add(stone);
            }
            return helper(set, 0, 0, stones[stones.length - 1], new HashSet<>());
        }

        private boolean helper(Set<Integer> stones, int pos, int jump, int target,
                               Set<Pair<Integer, Integer>> failed) {
            if(pos == target) {
                return true;
            }
            if(!stones.contains(pos)) {
                return false;
            }
            Pair<Integer, Integer> pair = new Pair<>(pos, jump);
            if(failed.contains(pair)) {
                return false;
            }

            if(jump > 1 && helper(stones, pos + jump - 1, jump - 1, target, failed)) {
                return true;
            }
            if(jump > 0 && helper(stones, pos + jump, jump, target, failed)) {
                return true;
            }
            if(helper(stones, pos + jump + 1, jump + 1, target, failed)) {
                return true;
            }
            failed.add(pair);
            return false;
        }
    }
}
