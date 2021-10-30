import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515_FindLargestValueinEachTreeRow {
    class Solution1 {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                int max = Integer.MIN_VALUE;
                for(int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    max = Math.max(max, cur.val);
                    if(cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if(cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                res.add(max);
            }
            return res;
        }
    }

    class Solution2 {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            helper(root, res, 0);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res, int d){
            if(root == null){
                return;
            }
            if(d == res.size()){
                res.add(root.val);
            }
            else{
                res.set(d, Math.max(res.get(d), root.val));
            }
            helper(root.left, res, d+1);
            helper(root.right, res, d+1);
        }
    }
}
