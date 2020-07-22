import java.util.PriorityQueue;
import java.util.TreeMap;

public class _1086_HighFive {
    class Solution {
        public int[][] highFive(int[][] items) {
            TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

            for(int[] item : items){
                int id = item[0];
                int score = item[1];
                map.putIfAbsent(id, new PriorityQueue<>());
                map.get(id).offer(score);
                if(map.get(id).size() > 5) {
                    map.get(id).poll();
                }
            }

            int index = 0;
            int[][] res = new int[map.size()][2];

            for(int id : map.keySet()){
                res[index][0] = id;
                PriorityQueue<Integer> pq = map.get(id);
                int sum = 0;
                int size = pq.size();
                while(!pq.isEmpty()){
                    sum+= pq.poll();
                }
                res[index][1] = sum/size;
                index++;
            }
            return res;
        }
    }
}
