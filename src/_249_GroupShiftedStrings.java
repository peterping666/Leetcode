import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _249_GroupShiftedStrings {
    /**
     * Time O(m * n) // m is the length of strings, n is the maximum length out of those strings
     * Space O(n)
     * @param strings
     * @return
     */
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String string : strings) {
            String key = getKey(string);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(string);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String string) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < string.length(); i++) {
            int diff = string.charAt(i) - string.charAt(i-1);
            diff = diff < 0 ? diff + 26 : diff;
            sb.append(diff + " ");
        }
        return sb.toString();
    }
}
