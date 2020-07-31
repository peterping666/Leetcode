import java.util.*;

public class _716_MaxStack {
    class MaxStack1 {
        private Deque<Integer> stack;
        private Deque<int[]> max;

        public MaxStack1() {
            stack = new ArrayDeque<>();
            max = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.offerFirst(x);
            if(max.isEmpty() || max.peekFirst()[0] < x) {
                max.offerFirst(new int[]{x, stack.size()});
            }
        }

        public int pop() {
            int res = stack.pollFirst();
            if(stack.size() < max.peekFirst()[1]) {
                max.pollFirst();
            }
            return res;
        }

        public int top() {
            return stack.peekFirst();
        }

        public int peekMax() {
            return max.peekFirst()[0];
        }

        public int popMax() {
            Deque<Integer> buffer = new ArrayDeque<>();
            int m = max.peekFirst()[0];
            while(stack.peekFirst() != m) {
                buffer.offerFirst(pop());
            }
            pop();
            while(!buffer.isEmpty()) {
                push(buffer.pollFirst());
            }
            return m;
        }
    }

    /**
     *
     */
    class MaxStack2 {
        TreeMap<Integer, List<Node>> map;
        DoubleLinkedList dll;

        public MaxStack2() {
            map = new TreeMap();
            dll = new DoubleLinkedList();
        }

        public void push(int x) {
            Node node = dll.add(x);
            if(!map.containsKey(x))
                map.put(x, new ArrayList<>());
            map.get(x).add(node);
        }

        public int pop() {
            int val = dll.pop();
            List<Node> L = map.get(val);
            L.remove(L.size() - 1);
            if (L.isEmpty()) map.remove(val);
            return val;
        }

        public int top() {
            return dll.peek();
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int max = peekMax();
            List<Node> L = map.get(max);
            Node node = L.remove(L.size() - 1);
            dll.unlink(node);
            if (L.isEmpty()) map.remove(max);
            return max;
        }
    }

    class DoubleLinkedList {
        Node head, tail;

        public DoubleLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        public Node add(int val) {
            Node x = new Node(val);
            x.next = tail;
            x.prev = tail.prev;
            tail.prev = tail.prev.next = x;
            return x;
        }

        public int pop() {
            return unlink(tail.prev).val;
        }

        public int peek() {
            return tail.prev.val;
        }

        public Node unlink(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }

    class Node {
        int val;
        Node prev, next;
        public Node(int v) {val = v;}
    }
}
