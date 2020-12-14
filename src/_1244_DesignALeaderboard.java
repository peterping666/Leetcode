import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _1244_DesignALeaderboard {
    class Leaderboard {
        private Map<Integer, Integer> map;
        private Map<Integer, Integer> treeMap;

        public Leaderboard() {
            map = new HashMap<>();
            treeMap = new TreeMap<>(Collections.reverseOrder());
        }

        public void addScore(int playerId, int score) {
            if(!map.containsKey(playerId)) {
                map.put(playerId, score);
                treeMap.put(score, treeMap.getOrDefault(score, 0) + 1);
            } else {
                int preScore = map.get(playerId);
                int newScore = preScore + score;
                map.put(playerId, newScore);
                treeMap.put(newScore, treeMap.getOrDefault(newScore, 0) + 1);
                treeMap.put(preScore, treeMap.get(preScore) - 1);
                if(treeMap.get(preScore) == 0) {
                    treeMap.remove(preScore);
                }
            }
        }

        public int top(int K) {
            int sum = 0;
            for(int score : treeMap.keySet()) {
                int count = treeMap.get(score);
                if(K >= count) {
                    K -= count;
                    sum += score * count;
                } else {
                    sum += score * K;
                    break;
                }
            }
            return sum;
        }

        public void reset(int playerId) {
            int score = map.get(playerId);
            treeMap.put(score, treeMap.get(score) - 1);
            if(treeMap.get(score) == 0) {
                treeMap.remove(score);
            }
            map.remove(playerId);
        }
    }
}
