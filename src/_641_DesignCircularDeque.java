public class _641_DesignCircularDeque {
    class MyCircularDeque {

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        int[] deque;
        int head;
        int tail;

        public MyCircularDeque(int k) {
            deque = new int[k + 1];
            head = 0;
            tail = 1;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            deque[head] = value;
            head = head == 0 ? deque.length - 1 : head - 1;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            deque[tail] = value;
            tail = (tail + 1) % deque.length;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % deque.length;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = tail == 0 ? deque.length - 1 : tail - 1;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return deque[(head + 1) % deque.length];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            int index = tail == 0 ? deque.length - 1 : tail - 1;
            return deque[index];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return (head + 1) % deque.length == tail;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return head == tail;
        }
    }
}
