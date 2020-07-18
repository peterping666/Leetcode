package Laicode;

import java.util.HashMap;

public class _205_ImplementLRUCache {
    /**
     *
     * @param <K>
     * @param <V>
     */
    public class Solution<K, V> {
        // limit is the max capacity of the cache
        class Node {
            K key;
            V value;
            Node prev;
            Node next;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private HashMap<K, Node> map;
        private Node head;
        private Node tail;
        private final int limit;

        public Solution(int limit) {
            map = new HashMap<>();
            head = new Node(null, null);
            tail = head;
            this.limit = limit;
        }

        public void set(K key, V value) {
            if(!map.containsKey(key)) {
                Node node = new Node(key, value);
                map.put(key, node);
                append(node);
                if(map.size() > limit) {
                    map.remove(remove(head.next));
                }
            } else {
                Node node = map.get(key);
                node.value = value;
                moveNodeToTail(node);
            }
        }

        public V get(K key) {
            if(!map.containsKey(key)) {
                return null;
            }

            Node node = map.get(key);
            moveNodeToTail(node);
            return node.value;
        }

        private void moveNodeToTail(Node node) {
            if(node == tail) {
                return;
            }
            remove(node);
            append(node);
        }

        private void append(Node node) {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }

        private K remove(Node node) {
            if(node == tail) {
                tail = tail.prev;
                tail.next = null;
                node.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                node.next = null;
            }
            return node.key;
        }
    }
}
