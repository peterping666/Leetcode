import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _95_UniqueBinarySearchTreesII {
    /**
     * Time O()
     * Space O()
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTreeList(1, n);
    }

    public List<TreeNode> generateTreeList(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTreeList = generateTreeList(start, i - 1);
            List<TreeNode> rightTreeList = generateTreeList(i + 1, end);
            for (TreeNode left : leftTreeList) {
                for (TreeNode right : rightTreeList) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    list.add(cur);
                }
            }
        }
        return list;
    }
}
