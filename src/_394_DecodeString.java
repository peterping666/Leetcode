import java.util.ArrayDeque;
import java.util.Deque;

public class _394_DecodeString {

    class Solution {
        public String decodeString(String s) {
            Deque<String> prevStr = new ArrayDeque<>();
            Deque<Integer> count = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(Character.isDigit(ch)) {
                    int val = ch - '0';
                    while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        val = val * 10 + s.charAt(i + 1) - '0';
                        i++;
                    }
                    count.offerFirst(val);
                } else if(ch == '[') {
                    prevStr.offerFirst(sb.toString());
                    sb.setLength(0);
                } else if(ch == ']') {
                    int counter = count.pollFirst();
                    StringBuilder tmp = new StringBuilder();
                    while(counter > 0) {
                        tmp.append(sb);
                        counter--;
                    }
                    sb.setLength(0);
                    sb.append(prevStr.pollFirst()).append(tmp);
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }
}
