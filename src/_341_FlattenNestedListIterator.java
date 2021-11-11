import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class _341_FlattenNestedListIterator {
    public class NestedIterator implements Iterator<Integer> {
        private Deque<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack  = new ArrayDeque<>();
            for(int i = nestedList.size() - 1; i >= 0; i--) {
                stack.offerFirst(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pollFirst().getInteger();
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty()) {
                if(stack.peekFirst().isInteger()) {
                    return true;
                }
                List<NestedInteger> curList = stack.pollFirst().getList();
                for(int i = curList.size() - 1; i >= 0; i--) {
                    stack.offerFirst(curList.get(i));
                }
            }
            return false;
        }
    }

    public class NestedIterator2 implements Iterator<Integer> {

        Deque<NestedInteger> deque;

        public NestedIterator2(List<NestedInteger> nestedList) {
            deque = new ArrayDeque<>();
            for(NestedInteger n :  nestedList) {
                deque.offerLast(n);
            }
        }

        @Override
        public Integer next() {
            return deque.pollFirst().getInteger();
        }

        @Override
        public boolean hasNext() {
            if(deque.isEmpty()) {
                return false;
            }
            if(deque.peekFirst().isInteger()) {
                return true;
            }
            List<NestedInteger> curList = deque.pollFirst().getList();
            for(int i = curList.size() - 1; i>= 0; i--) {
                deque.offerFirst(curList.get(i));
            }
            return hasNext();
        }
    }

    public interface NestedInteger {

        // return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
  }
}
