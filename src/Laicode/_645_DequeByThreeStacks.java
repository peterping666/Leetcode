package Laicode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _645_DequeByThreeStacks {
    public class Solution {
        private Deque<Integer> left;
        private Deque<Integer> right;
        private Deque<Integer> buffer;
        public Solution() {
            left = new ArrayDeque<>();
            right = new ArrayDeque<>();
            buffer = new ArrayDeque<>();
        }

        public void offerFirst(int element) {
            left.offerFirst(element);
        }

        public void offerLast(int element) {
            right.offerFirst(element);
        }

        public Integer pollFirst() {
            move(right, left);
            return left.isEmpty() ? null : left.pollFirst();
        }

        public Integer pollLast() {
            move(left, right);
            return right.isEmpty() ? null : right.pollFirst();
        }

        public Integer peekFirst() {
            move(right, left);
            return left.isEmpty() ? null : left.peekFirst();
        }

        public Integer peekLast() {
            move(left, right);
            return right.isEmpty() ? null : right.peekFirst();
        }

        public int size() {
            return left.size() + right.size();
        }

        public boolean isEmpty() {
            return left.isEmpty() && right.isEmpty();
        }

        private void move(Deque<Integer> src, Deque<Integer> dest) {
            if(!dest.isEmpty()) {
                return;
            }
            int mid = src.size() / 2;
            while(mid-- != 0) {
                buffer.offerFirst(src.pollFirst());
            }
            while(!src.isEmpty()) {
                dest.offerFirst(src.pollFirst());
            }
            while(!buffer.isEmpty()) {
                src.offerFirst(buffer.pollFirst());
            }
        }
    }
}
