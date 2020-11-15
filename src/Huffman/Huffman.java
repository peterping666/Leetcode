package Huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    class HuffmanNode {
        int data;
        char c;
        HuffmanNode left;
        HuffmanNode right;

        HuffmanNode(int d, char c) {
            data = d;
            this.c = c;
        }

        HuffmanNode(int d, char c, HuffmanNode l, HuffmanNode r) {
            data = d;
            this.c = c;
            left = l;
            right = r;
        }
    }

    public HuffmanNode buildTree(PriorityQueue<HuffmanNode> q) {
        while (q.size() > 1) {
            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();
            int sum = x.data + y.data;
            HuffmanNode f = new HuffmanNode(sum, '-', x, y);
            q.add(f);
        }
        return q.peek();
    }

    public String encode(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - '0']++;
        }
        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<HuffmanNode>((a,b) -> Integer.compare(b.data, a.data));

        for (int i = 0; i < freq.length; i++) {
            HuffmanNode hn = new HuffmanNode(freq[i], (char)(i + '0'));
            q.add(hn);
        }
        HuffmanNode root = buildTree(q);

        Map<Character,String> huffmanCode = new HashMap<>();
        addCode(root, "", huffmanCode);

        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }
        return sb.toString();
    }

    public void addCode(HuffmanNode root, String str, Map<Character,String> huffmanCode) {
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null) {
            huffmanCode.put(root.c, str);
        }
        addCode(root.left, str + '0', huffmanCode);
        addCode(root.right, str + '1', huffmanCode);
    }

    public int decode(HuffmanNode root, int index, String sb) {
        if (root == null) {
            return index;
        }
        if (root.left == null && root.right == null) {
            System.out.print(root.c);
            return index;
        }
        index++;
        if (sb.charAt(index) == '0') {
            index = decode(root.left, index, sb);
        } else {
            index = decode(root.right, index, sb);
        }
        return index;
    }

    public void main(String s) {
        HuffmanNode root = new HuffmanNode(1, '0');
        int index = -1;
        while (index < s.length() - 2) {
            index = decode(root, index, s);
        }
    }
}
