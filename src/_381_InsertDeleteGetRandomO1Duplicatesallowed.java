import java.util.*;

public class _381_InsertDeleteGetRandomO1Duplicatesallowed {
    class RandomizedCollection {

        /** Initialize your data structure here. */
        HashMap<Integer, HashSet<Integer>> map;
        List<Integer> list;
        Random rdm;
        public RandomizedCollection() {
            rdm = new Random();
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean isInserted = false;
            if(!map.containsKey(val)) {
                map.put(val, new HashSet<>());
                isInserted = true;
            }
            map.get(val).add(list.size());
            list.add(val);
            return isInserted;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            HashSet<Integer> set = map.get(val);
            int idx = set.iterator().next();
            set.remove(idx);
            if(idx != list.size() - 1) {
                int lastVal = list.get(list.size() - 1);
                list.set(idx, lastVal);
                map.get(lastVal).add(idx);
                map.get(lastVal).remove(list.size() - 1);
            }
            if(set.size() == 0) map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get(rdm.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
