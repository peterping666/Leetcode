package Laicode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _198_LargestRectangleInHistogram {
    public class Solution {
        public int largest(int[] array) {
            // Write your solution here
            Deque<Integer> stack = new ArrayDeque<>();
            int res = 0;
            for(int i = 0; i <= array.length; i++) {
                int cur = i == array.length ? 0 : array[i];
                while(!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
                    int height = array[stack.pollFirst()];
                    int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                    res = Math.max(res, (i - left) * height);
                }
                stack.offerFirst(i);
            }
            return res;
        }
    }

}
