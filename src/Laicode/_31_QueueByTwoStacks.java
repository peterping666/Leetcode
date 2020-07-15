package Laicode;

import java.util.LinkedList;

public class _31_QueueByTwoStacks {
    public class Solution {
        LinkedList<Integer> in;
        LinkedList<Integer> out;
        public Solution() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        public Integer poll() {
            if(!out.isEmpty()) {
                return out.pollLast();
            }
            while(!in.isEmpty()) {
                out.offerLast(in.pollLast());
            }
            return out.pollLast();
        }

        public void offer(int element) {
            in.offerLast(element);
        }

        public Integer peek() {
            if(!out.isEmpty()) {
                return out.peekLast();
            }
            return in.peekFirst();
        }

        public int size() {
            return in.size() + out.size();
        }

        public boolean isEmpty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
