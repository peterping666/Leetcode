import java.util.HashMap;
import java.util.TreeMap;

public class _981_TimeBasedKeyValueStore {
    class TimeMap {

        /** Initialize your data structure here. */
        HashMap<String, TreeMap<Integer, String>> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key)) {
                return "";
            }
            Integer time = map.get(key).floorKey(timestamp);
            return time == null ? "" : map.get(key).get(time);
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
