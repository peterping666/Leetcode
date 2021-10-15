import java.util.*;

public class _380_InsertDeleteGetRandomO1 {
    class RandomizedSet {
        /** Initialize your data structure here. */

        private List<Integer> list;
        private Map<Integer, Integer> map;
        private Random rand;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            rand = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            if(index == list.size() - 1) {
                list.remove(list.size() - 1);
            } else {
                int lastVal = list.remove(list.size() - 1);
                list.set(index, lastVal);
                map.put(lastVal, index);
            }
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
