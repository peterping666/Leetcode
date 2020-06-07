import java.util.HashMap;
import java.util.Map;

public class _246_StrobogrammaticNumber {
    /**
     * Time O(n)
     * Space O(1)
     * @param num
     * @return
     */
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        int left = 0, right = num.length() - 1;
        while(left <= right) {
            if(!map.containsKey(num.charAt(left))) {
                return false;
            }
            if(map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
