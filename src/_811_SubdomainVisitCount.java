import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _811_SubdomainVisitCount {
    class Solution1 {
        public List<String> subdomainVisits(String[] cpdomains) {
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < cpdomains.length; i++) {
                int space = cpdomains[i].indexOf(" ");
                int firstDot = cpdomains[i].indexOf('.');
                int secondDot = cpdomains[i].indexOf('.', firstDot + 1);
                int num = Integer.parseInt(cpdomains[i].substring(0, space));
                String firstKey = cpdomains[i].substring(space + 1);
                map.put(firstKey, map.getOrDefault(firstKey, 0) + num);
                String secondKey = cpdomains[i].substring(firstDot + 1);
                map.put(secondKey, map.getOrDefault(secondKey, 0) + num);
                if(secondDot == -1) {
                    continue;
                }
                String thirdKey = cpdomains[i].substring(secondDot + 1);
                map.put(thirdKey, map.getOrDefault(thirdKey, 0) + num);
            }
            List<String> res = new ArrayList<>();
            for(String domain : map.keySet()) {
                res.add(map.get(domain) + " " + domain);
            }
            return res;
        }
    }

    class Solution2 {
        public List<String> subdomainVisits(String[] cpdomains) {
            HashMap<String, Integer> map = new HashMap<>();
            for(String domain : cpdomains) {
                String[] strs = domain.split(" ");
                String[] names = strs[1].split("\\.");
                int count = Integer.parseInt(strs[0]);
                String name = "";
                for(int i = names.length - 1; i>= 0; i--) {
                    name = names[i] + (i == names.length - 1 ? "" : ".") + name;
                    map.put(name, map.getOrDefault(name, 0) + count);
                }
            }
            List<String> res = new ArrayList<>();
            for(String domain : map.keySet()) {
                res.add(map.get(domain) + " " + domain);
            }
            return res;
        }
    }
}
