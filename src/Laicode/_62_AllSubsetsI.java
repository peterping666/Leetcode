package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _62_AllSubsetsI {
    /**
     *
     */
    public class Solution1 {
        public List<String> subSets(String set) {
            List<String> res = new ArrayList<>();
            if(set == null) {
                return res;
            }
            char[] charSet = set.toCharArray();
            dfs(res, charSet, 0, new StringBuilder());
            return res;
        }

        private void dfs(List<String> res, char[] set, int index, StringBuilder path) {
            if(index == set.length) {
                res.add(path.toString());
                return;
            }
            dfs(res, set, index + 1, path);
            dfs(res, set, index +1, path.append(set[index]));
            path.deleteCharAt(path.length() - 1);
        }
    }

    /**
     *
     */
    public class Solution2 {
        public List<String> subSets(String set) {
            List<String> res = new ArrayList<>();
            if(set == null) {
                return res;
            }
            char[] charSet = set.toCharArray();
            dfs(res, charSet, 0, new StringBuilder());
            return res;
        }

        private void dfs(List<String> res, char[] set, int index, StringBuilder path) {
            res.add(path.toString());
            for(int i = index; i < set.length; i++) {
                dfs(res, set, i + 1, path.append(set[i]));
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
