import java.util.*;

public class _428_SerializeandDeserializeNaryTree {
    class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            List<String> list = new ArrayList<>();
            serializeHelper(root, list);
            return String.join(",", list);
        }
        private void serializeHelper(Node node, List<String> list) {
            if(node == null) return;
            int size = node.children.size();
            list.add(String.valueOf(node.val));
            list.add(String.valueOf(size));
            for(Node child : node.children) {
                serializeHelper(child, list);
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if(data == null || data.length() == 0) return null;
            String[] strs = data.split(",");
            Queue<String> queue = new LinkedList<>(Arrays.asList(strs));
            return deserializeHelper(queue);
        }
        private Node deserializeHelper(Queue<String> queue) {
            Node root = new Node(Integer.parseInt(queue.poll()));
            int size = Integer.parseInt(queue.poll());
            root.children = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                root.children.add(deserializeHelper(queue));
            }
            return root;
        }
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
