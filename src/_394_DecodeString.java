import java.util.Stack;

public class _394_DecodeString {

    class Solution {
        /**
         * Time O(n)
         * Space O(n)
         * @param s
         * @return
         */
        public String decodeString(String s) {
            Stack<Integer> numStack = new Stack<>();
            Stack<String> strStack = new Stack<>();
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                if(Character.isDigit(s.charAt(i))) {
                    int num = s.charAt(i) - '0';
                    while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                        i++;
                        num = num * 10 + s.charAt(i) - '0';
                    }
                    numStack.push(num);
                } else if(s.charAt(i) == '[') {
                    strStack.push(str.toString());
                    str.setLength(0);
                } else if(s.charAt(i) == ']') {
                    StringBuilder sb = new StringBuilder();
                    int count = numStack.pop();
                    for(int j = 0; j < count; j++) {
                        sb.append(str);
                    }
                    str.setLength(0);
                    str.append(strStack.pop()).append(sb.toString());
                } else {
                    str.append(s.charAt(i));
                }
            }
            return str.toString();
        }
    }
}
