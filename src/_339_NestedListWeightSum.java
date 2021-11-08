import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _339_NestedListWeightSum {

    class Solution1 {
        public int depthSum(List<NestedInteger> nestedList) {
            return helper(nestedList, 1);
        }
        public int helper(List<NestedInteger> nestedList, int level) {
            int result = 0;
            for(NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    result += (level * ni.getInteger());
                }else {
                    result += helper(ni.getList(), level + 1);
                }
            }
            return result;
        }
    }

    class Solution2 {
        public int depthSum(List<NestedInteger> nestedList) {
            if(nestedList == null){
                return 0;
            }
            int sum = 0;
            int level = 1;
            Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
            while(queue.size() > 0){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    NestedInteger ni = queue.poll();
                    if(ni.isInteger()){
                        sum += ni.getInteger() * level;
                    }else{
                        queue.addAll(ni.getList());
                    }
                }
                level++;
            }
            return sum;
        }
    }



    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);
        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
