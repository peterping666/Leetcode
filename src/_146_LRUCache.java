import java.util.HashMap;
import java.util.Map;

public class _146_LRUCache {
    class LRUCache {
        private int cap;
        private int size;
        private Node head;
        private Node tail;
        private Map<Integer, Node> map;

        public LRUCache(int capacity) {
            cap = capacity;
            size = 0;
            head = new Node(0,0);
            tail = new Node(0,0);
            map = new HashMap<>();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.val;

        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                remove(node);
            } else {
                map.put(key, new Node(key, value));
            }
            add(map.get(key));
            if(size > cap) {
                Node node = head.next;
                head.next = head.next.next;
                remove(node);
                map.remove(node.key); // very important
            }
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            size--;
        }

        private void add(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }


        class Node{
            int key;
            int val;
            Node prev;
            Node next;
            Node(int k, int v) {
                key = k;
                val = v;
            }
        }
    }
}
