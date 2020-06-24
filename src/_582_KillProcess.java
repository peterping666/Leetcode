import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _582_KillProcess {
    /**
     * Time O(n)
     * Space O(n)
     * @param pid
     * @param ppid
     * @param kill
     * @return
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++) {
            if(ppid.get(i) > 0) {
                List<Integer> l = map.getOrDefault(ppid.get(i), new ArrayList<>());
                l.add(pid.get(i));
                map.put(ppid.get(i), l);
            }
        }
        list.add(kill);
        getAllChildren(list, map, kill);
        return list;
    }

    private void getAllChildren(List<Integer> list, HashMap<Integer, List<Integer>> map, int kill) {
        if(map.containsKey(kill)) {
            for(int num : map.get(kill)) {
                list.add(num);
                getAllChildren(list, map, num);
            }
        }
    }
}
