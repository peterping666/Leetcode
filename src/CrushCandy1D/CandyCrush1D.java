package CrushCandy1D;

import java.util.ArrayDeque;
import java.util.Deque;

public class CandyCrush1D {
    public String solution(String input) {
        if(input.length() == 0) {
            return "";
        }
        Deque<Character> charStack = new ArrayDeque<>();
        Deque<Integer> freqStack = new ArrayDeque<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(charStack.isEmpty() || c != charStack.peekFirst()) {
                if(!charStack.isEmpty() && freqStack.peekFirst() >= 3) {
                    charStack.pollFirst();
                    freqStack.pollFirst();
                    i--;
                } else {
                    charStack.offerFirst(c);
                    freqStack.offerFirst(1);
                }
            } else {
                freqStack.offerFirst(freqStack.pollFirst() + 1);
            }
        }

        if (freqStack.peekFirst() >= 3) {
            charStack.pollFirst();
            freqStack.pollFirst();
        }

        StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty()) {
            char c = charStack.pollFirst();
            int count = freqStack.pollFirst();
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }
        return sb.reverse().toString();
    }
}
