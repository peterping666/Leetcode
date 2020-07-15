package Laicode;

import java.util.Deque;
import java.util.LinkedList;

public class _280_SortWith2Stacks {
    public class Solution {
        public void sort(LinkedList<Integer> s1) {
            LinkedList<Integer> s2 = new LinkedList<Integer>();
            // Write your solution here.
            while(!s1.isEmpty()) {
                s2.offerLast(s1.pollLast());
            }
            sort(s1, s2);
        }

        private void sort(Deque<Integer> input, Deque<Integer> buffer) {
            while(!buffer.isEmpty()) {
                int curMin = buffer.peekLast();
                int size = buffer.size();
                while(!buffer.isEmpty()) {
                    int num = buffer.pollLast();
                    curMin = Math.min(curMin, num);
                    input.offerLast(num);
                }
                int count = 0;
                while(size > 0) {
                    int num = input.pollLast();
                    if(num != curMin) {
                        buffer.offerLast(num);
                    } else {
                        count++;
                    }
                    size--;
                }
                while(count > 0) {
                    input.offerLast(curMin);
                    count--;
                }
            }
        }
    }
}
