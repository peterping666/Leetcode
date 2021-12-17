import java.util.ArrayDeque;
import java.util.Deque;

public class _394_DecodeString {

    class Solution1 {
        public String decodeString(String s) {
            Deque<StringBuilder> prevStr = new ArrayDeque<>();
            Deque<Integer> count = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(Character.isDigit(c)) {
                    int num = 0;
                    while(i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    count.offerFirst(num);
                    prevStr.offerFirst(sb);
                    sb = new StringBuilder();
                } else if(c == ']') {
                    int num = count.pollFirst();
                    StringBuilder decode = prevStr.pollFirst();
                    while(num-- > 0) {
                        decode.append(sb);
                    }
                    sb = decode;
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    class Solution2 {
        public String decodeString(String s) {
            Deque<StringBuilder> prevStr = new ArrayDeque<>();
            Deque<Integer> count = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(Character.isDigit(c)) {
                    int num = c - '0';
                    while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        num = num * 10 + s.charAt(i + 1) - '0';
                        i++;
                    }
                    count.offerFirst(num);
                } else if(c == '[') {
                    prevStr.offerFirst(sb);
                    sb = new StringBuilder();
                } else if(c == ']') {
                    int num = count.pollFirst();
                    StringBuilder decode = prevStr.pollFirst();
                    while(num-- > 0) {
                        decode.append(sb);
                    }
                    sb = decode;
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
