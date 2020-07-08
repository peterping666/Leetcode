import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class _380_InsertDeleteGetRandomO1 {
    class RandomizedSet {

        /** Initialize your data structure here. */
        Random rdm;
        List<Integer> list;
        HashMap<Integer, Integer> map;
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            rdm = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            if(map.get(val) != list.size() - 1) {
                int idx = map.get(val);
                list.set(idx, list.get(list.size() - 1));
                map.put(list.get(idx), idx);
            }
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = rdm.nextInt(list.size());
            return list.get(idx);
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
