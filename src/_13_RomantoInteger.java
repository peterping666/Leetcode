import java.util.HashMap;

public class _13_RomantoInteger {
    /**
     * Time O(n)
     * Space O(1)
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        HashMap<Character, Integer> values = new HashMap<>();
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            int val = values.get(s.charAt(i));
            if(i != s.length() - 1 && val < values.get(s.charAt(i + 1))) {
                sum -= val;
            } else {
                sum += val;
            }
        }
        return sum;
    }
}
