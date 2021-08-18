import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _582_KillProcess {
    class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            List<Integer> list = new ArrayList<>();
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < ppid.size(); i++) {
                if(ppid.get(i) > 0) {
                    map.putIfAbsent(ppid.get(i), new ArrayList<>());
                    map.get(ppid.get(i)).add(pid.get(i));
                }
            }
            getAllChildren(list, map, kill);
            return list;
        }

        private void getAllChildren(List<Integer> list, HashMap<Integer, List<Integer>> map, int kill) {
            list.add(kill);
            if(map.containsKey(kill)) {
                for(int num : map.get(kill)) {
                    getAllChildren(list, map, num);
                }
            }
        }
    }
}
