import java.util.ArrayList;
import java.util.List;

public class _71_SimplifyPath {
    class Solution {
        public String simplifyPath(String path) {
            List<String> list = new ArrayList<>();
            for (String dir : path.split("/")) {
                if (dir.equals("..")) {
                    if(list.size() != 0) {
                        list.remove(list.size() - 1);
                    }
                } else if (!dir.equals(".") && !dir.equals("")) {
                    list.add(dir);
                }
            }

            if (list.size() == 0) {
                return "/";
            }

            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                sb.append("/").append(str);
            }
            return sb.toString();
        }
    }
}
