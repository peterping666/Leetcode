public class _622_DesignCircularQueue {
    class MyCircularQueue1 {

        /** Initialize your data structure here. Set the size of the queue to be k. */
        int[] q;
        int head;
        int tail;
        public MyCircularQueue1(int k) {
            q = new int[k + 1];
            head = 0;
            tail = 1;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(isFull()) {
                return false;
            }
            q[tail] = value;
            tail = (tail + 1) % q.length;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(isEmpty()) {
                return false;
            }
            head = (head + 1) % q.length;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if(isEmpty()) {
                return -1;
            }
            return q[(head+1) % q.length];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if(isEmpty()) {
                return -1;
            }
            return tail == 0 ? q[q.length - 1] : q[(tail-1) % q.length];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return (head + 1) % q.length == tail;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return tail == head;
        }
    }

    class MyCircularQueue2 {

        private int[] queue;
        private int headIndex;
        private int count;
        private int capacity;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue2(int k) {
            this.capacity = k;
            this.queue = new int[k];
            this.headIndex = 0;
            this.count = 0;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (this.count == this.capacity)
                return false;
            this.queue[(this.headIndex + this.count) % this.capacity] = value;
            this.count += 1;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (this.count == 0)
                return false;
            this.headIndex = (this.headIndex + 1) % this.capacity;
            this.count -= 1;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (this.count == 0)
                return -1;
            return this.queue[this.headIndex];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (this.count == 0)
                return -1;
            int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
            return this.queue[tailIndex];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return (this.count == 0);
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return (this.count == this.capacity);
        }
    }
}
