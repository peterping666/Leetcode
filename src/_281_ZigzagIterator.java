import java.util.Iterator;
import java.util.List;

public class _281_ZigzagIterator {
    public class ZigzagIterator {

        private Iterator<Integer> i1, i2, temp;
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            i1 = v1.iterator();
            i2 = v2.iterator();
        }

        public int next() {
            if(i1.hasNext()) {
                temp = i1;
                i1 = i2;
                i2 = temp;
            }
            return i2.next();
        }

        public boolean hasNext() {
            return i1.hasNext() || i2.hasNext();
        }
    }

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
