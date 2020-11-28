package CrushCandy1D;

import java.util.Stack;

public class CandyCrush1D {
    public String solution(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> occurrence = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c != stack.peek()) {
                if (!stack.isEmpty() && occurrence.peek() >= 3) {
                    stack.pop();
                    occurrence.pop();
                } else {
                    stack.push(c);
                    occurrence.push(1);
                    i++;
                }
            } else {
                int count = occurrence.pop();
                occurrence.push(count + 1);
                i++;
            }
        }

        if (occurrence.peek() >= 3) {
            stack.pop();
            occurrence.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            int count = occurrence.pop();
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }

        return sb.reverse().toString();
    }
}
