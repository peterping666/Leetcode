public class _705_DesignHashSet {
    class MyHashSet {

        /** Initialize your data structure here. */
        class Node {
            int key;
            Node next;

            Node(int key) {
                this.key = key;
            }
        }

        Node[] array;;
        int size;
        public MyHashSet() {
            array = new Node[1000000];
            size = 0;
        }

        private int getIndex(int key) {
            return key % array.length;
        }

        public void add(int key) {
            int index = getIndex(key);
            Node node = array[index];
            while(node != null) {
                if(node.key == key) {
                    return;
                }
                node = node.next;
            }
            Node newNode = new Node(key);
            newNode.next = array[index];
            array[index] = newNode;
            size++;
        }

        public void remove(int key) {
            int index = getIndex(key);
            Node node = array[index];
            Node prev = null;
            while(node != null) {
                if(node.key == key) {
                    if(prev == null) {
                        array[index] = null;
                    } else {
                        prev.next = node.next;
                    }
                    size--;
                    return;
                }
                prev = node;
                node = node.next;
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int index = getIndex(key);
            Node node = array[index];
            while(node != null) {
                if(node.key == key) {
                    return true;
                }
                node = node.next;
            }
            return false;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
