package Laicode;

import java.util.HashMap;
import java.util.Map;

public class _78_HexadecimalRepresentation {
    public class Solution {
        public String hex(int number) {
            Map<Integer, Character> map = new HashMap<>();
            map.put(10, 'A');
            map.put(11, 'B');
            map.put(12, 'C');
            map.put(13, 'D');
            map.put(14, 'E');
            map.put(15, 'F');
            StringBuilder sb = new StringBuilder();
            if(number == 0) {
                return "0x0";
            }
            while(number != 0) {
                int value = number & 15;
                number >>>= 4;
                if(value >= 10) {
                    sb.append(map.get(value));
                } else {
                    sb.append(value);
                }
            }
            sb.append("x0");
            return sb.reverse().toString();
        }
    }

}
