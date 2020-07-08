import java.util.HashMap;

public class _170_TwoSumIIIDatastructuredesign {
    class TwoSum {
        /** Initialize your data structure here. */
        HashMap<Integer, Integer> map;
        public TwoSum() {
            map = new HashMap<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for(int key : map.keySet()) {
                int target = value - key;
                if(map.containsKey(target)) {
                    if(key != target || map.get(key) > 1) return true;
                }
            }
            return false;
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
}
