import java.util.*;

public class _1743_RestoretheArrayFromAdjacentPairs {
    class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] adjacentPair: adjacentPairs) {
                map.putIfAbsent(adjacentPair[0], new ArrayList<>());
                map.get(adjacentPair[0]).add(adjacentPair[1]);

                map.putIfAbsent(adjacentPair[1], new ArrayList<>());
                map.get(adjacentPair[1]).add(adjacentPair[0]);
            }
            int start = 0;
            for (int key: map.keySet()) {
                if (map.get(key).size() == 1) {
                    start = key;
                    break;
                }
            }

            int[] res = new int[adjacentPairs.length + 1];
            helper(res, map, start, new HashSet<>(), 0);
            return res;
        }

        private void helper(int[] res, Map<Integer, List<Integer>> map, int cur, Set<Integer> set, int index) {
            if(!set.add(cur)) {
                return;
            }
            res[index] = cur;
            for(int num : map.get(cur)) {
                helper(res, map, num, set, index + 1);
            }
        }
    }
}
