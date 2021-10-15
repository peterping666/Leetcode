import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private int cap;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        cap = capacity;
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
            add(node);
        } else {
            Node newNode = new Node(key, value);
            add(newNode);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

    private void add(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        map.put(node.key, node);
        if(map.size() > cap) {
            remove(head.next);
        }
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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
