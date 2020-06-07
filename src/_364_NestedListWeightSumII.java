import java.util.ArrayList;
import java.util.List;

public class _364_NestedListWeightSumII {
    /**
     * Time O(n)
     * Space O(d) d is the maximum level of nesting in the input
     * @param nestedList
     * @return
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> nestedList, int res) {
        List<NestedInteger> nextList = new ArrayList<>();
        for(NestedInteger nestedInteger : nestedList) {
            if(nestedInteger.isInteger()) {
                res += nestedInteger.getInteger();
            } else {
                nextList.addAll(nestedInteger.getList());
            }
        }

        res += nextList.isEmpty() ? 0 : helper(nextList, res);
        return res;
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
        public void add(_339_NestedListWeightSum.NestedInteger ni);
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
