public class _706_DesignHashMap {
    class MyHashMap {

        /** Initialize your data structure here. */
        class Node{
            int key;
            int value;
            Node next;
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        Node[] array;
        int size;
        public MyHashMap() {
            array = new Node[1000000 + 1];
            size = 0;
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index = getIndex(key);
            Node node = array[index];
            while(node != null) {
                if(node.key == key) {
                    node.setValue(value);
                    return;
                }
                node = node.next;
            }
            Node newNode = new Node(key, value);
            newNode.next = array[index];
            array[index] = newNode;
            size++;
        }

        private int getIndex(int key) {
            return key % array.length;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index = getIndex(key);
            Node node = array[index];
            while(node != null) {
                if(node.key == key) {
                    return node.value;
                }
                node = node.next;
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index = getIndex(key);
            Node node = array[index];
            Node prev = null;
            while(node != null) {
                if(node.key == key) {
                    if(prev != null) {
                        prev.next = node.next;
                    } else {
                        array[index] = node.next;
                    }
                    size--;
                    return;
                }
                node = node.next;
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
