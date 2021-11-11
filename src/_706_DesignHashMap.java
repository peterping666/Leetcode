public class _706_DesignHashMap {
    class MyHashMap {

        private Node[] array;

        private class Node {
            int key;
            int value;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public MyHashMap() {
            array = new Node[1000000 + 1];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int index = getIndex(key);
            Node cur = array[index];
            while (cur != null) {
                if (cur.key == key) {
                    cur.value = value;
                    return;
                }
                cur = cur.next;
            }
            Node newNode = new Node(key, value);
            newNode.next = array[index];
            array[index] = newNode;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int index = getIndex(key);
            Node cur = array[index];
            while (cur != null) {
                if (cur.key == key) {
                    return cur.value;
                }
                cur = cur.next;
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int index = getIndex(key);
            Node cur = array[index];
            Node prev = null;
            while (cur != null) {
                if (cur.key == key) {
                    if (prev == null) {
                        array[index] = cur.next;
                    } else {
                        prev.next = cur.next;
                        cur.next = null;
                    }
                    return;
                }
                prev = cur;
                cur = cur.next;
            }
        }

        private int getIndex(int key) {
            return key % array.length;
        }
    }
}
