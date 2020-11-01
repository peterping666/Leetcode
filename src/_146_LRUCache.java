import java.util.HashMap;
import java.util.Map;

public class _146_LRUCache {
    class LRUCache {
        private Node head;
        private Node tail;
        private int capacity;
        private Map<Integer, Node> map;
        private int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            size = 0;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(!map.containsKey(key)) {
                return -1;
            }
            Node target = map.get(key);
            moveToTail(target);
            return target.value;
        }

        public void put(int key, int value) {
            if(!map.containsKey(key)) {
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                size++;
                add(newNode);
                if(size > capacity) {
                    map.remove(head.next.key);
                    remove(head.next);
                    size--;
                }
                return;
            }
            Node target = map.get(key);
            target.value = value;
            moveToTail(target);
        }

        private void add(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }

        private void remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        private void moveToTail(Node node) {
            remove(node);
            add(node);
        }

        private class Node {
            int key;
            int value;
            Node next;
            Node prev;
            Node() {
                key = 0;
                value = 0;
            }
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
