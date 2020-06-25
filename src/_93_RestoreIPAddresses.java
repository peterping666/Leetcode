import java.util.ArrayList;
import java.util.List;

public class _93_RestoreIPAddresses {
    /**
     * Time O(3^4)
     * Space O(4)
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        helper(list, 0, "", 0, s);
        return list;
    }

    private void helper(List<String> list, int idx, String path, int count, String s) {
        if(count > 4) return;
        if(count == 4 && idx == s.length()) {
            list.add(path);
            return;
        }

        for(int i = 1; i < 4; i++) {
            if(idx + i > s.length()) break;
            String tmp = s.substring(idx, idx + i);
            if(tmp.startsWith("0") && tmp.length() > 1
                    || i == 3 && Integer.parseInt(tmp) > 255) continue;
            helper(list, idx + i, path + tmp + (count == 3 ? "" : "."), count + 1, s);
        }
    }
}
