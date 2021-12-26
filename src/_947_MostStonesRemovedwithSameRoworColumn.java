import java.util.HashMap;
import java.util.Map;

public class _947_MostStonesRemovedwithSameRoworColumn {
    class Solution {
        public int removeStones(int[][] stones) {
            UnionFind uf = new UnionFind(stones);
            for(int i = 0; i < stones.length; i++) {
                for(int j = i + 1; j < stones.length; j++) {
                    if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                        uf.union(stones[i][0] + "-" + stones[i][1], stones[j][0] + "-" + stones[j][1]);
                    }
                }
            }
            return stones.length - uf.count;
        }

        class UnionFind {
            Map<String, String> parent;
            int count;

            UnionFind(int[][] stones) {
                parent = new HashMap<>();
                for(int i = 0; i < stones.length; i++) {
                    String s = stones[i][0] + "-" + stones[i][1];
                    parent.put(s, s);
                }
                count = stones.length;
            }

            public String find(String s) {
                if(parent.get(s) != s) {
                    parent.put(s, find(parent.get(s)));
                }
                return parent.get(s);
            }

            public void union(String s1, String s2) {
                String p1 = find(s1);
                String p2 = find(s2);
                if(!p1.equals(p2)) {
                    parent.put(p1, p2);
                    count--;
                }
            }
        }
    }
}
