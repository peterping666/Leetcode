import java.util.*;

public class _1152_AnalyzeUserWebsiteVisitPattern {
    class Solution {
        public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
            Map<String, List<Pair>> map = new HashMap<>();
            for(int i = 0; i < username.length; i++) {
                map.putIfAbsent(username[i], new ArrayList<>());
                map.get(username[i]).add(new Pair(timestamp[i], website[i]));
            }
            Map<String, Integer> count = new HashMap<>();
            String res = null;
            for(String name : map.keySet()) {
                Set<String> set = new HashSet<>();
                List<Pair> list = map.get(name);
                Collections.sort(list, (a, b) -> a.time.compareTo(b.time));
                for(int i = 0; i < list.size(); i++) {
                    for(int j = i + 1; j < list.size(); j++) {
                        for(int k = j + 1; k < list.size(); k++) {
                            String pattern = list.get(i).website + " " +
                                    list.get(j).website + " " + list.get(k).website;
                            if(set.add(pattern)) {
                                count.put(pattern, count.getOrDefault(pattern, 0) + 1);
                            }
                            if(res == null || count.get(pattern) > count.get(res) ||
                                    count.get(pattern) == count.get(res) && pattern.compareTo(res) < 0) {
                                res = pattern;
                            }
                        }
                    }
                }
            }
            return Arrays.asList(res.split(" "));
        }

        class Pair {
            Integer time;
            String website;

            Pair(int t, String w) {
                time = t;
                website = w;
            }
        }
    }
}
