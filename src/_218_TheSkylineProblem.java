import java.util.*;

public class _218_TheSkylineProblem {
    /**
     * Time O(nlogn)
     * Space O(n)
     */
    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            int n = buildings.length;
            List<int[]> list = new ArrayList<>();
            for(int[] b : buildings) {
                list.add(new int[]{b[0], -b[2]});
                list.add(new int[]{b[1], b[2]});
            }
            Collections.sort(list, (a,b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
            TreeMap<Integer, Integer> treemap = new TreeMap<>();
            treemap.put(0, 1);
            List<List<Integer>> res = new ArrayList<>();
            int max = 0;
            for(int[] b : list) {
                if(b[1] < 0) {
                    treemap.put(-b[1], treemap.getOrDefault(-b[1], 0) + 1);
                } else {
                    treemap.put(b[1], treemap.get(b[1]) - 1);
                    if(treemap.get(b[1]) == 0) {
                        treemap.remove(b[1]);
                    }
                }
                int cur = treemap.lastKey();
                if(max != cur) {
                    max = cur;
                    res.add(Arrays.asList(b[0], cur));
                }
            }
            return res;
        }
    }
}
