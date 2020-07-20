import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _609_FindDuplicateFileinSystem {
    class Solution {
        public List<List<String>> findDuplicate(String[] paths) {
            HashMap<String, List<String>> map = new HashMap<>();
            for(String path : paths) {
                String[] strs = path.split(" ");
                for(int i = 1; i < strs.length; i++) {
                    int left = strs[i].indexOf('(');
                    int right = strs[i].indexOf(')');
                    String key = strs[i].substring(left + 1, right);
                    map.putIfAbsent(key, new ArrayList<>());
                    map.get(key).add(strs[0] + "/" + strs[i].substring(0, left));
                }
            }

            List<List<String>> res = new ArrayList<>();
            for(String key : map.keySet()) {
                if(map.get(key).size() > 1) {
                    res.add(map.get(key));
                }
            }
            return res;
        }
    }
}
