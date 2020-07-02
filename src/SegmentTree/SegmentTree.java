package SegmentTree;

public class SegmentTree {
    /**
     * Time O(n)
     * @param i
     * @param j
     * @param nums
     * @return
     */
    public Node build(int i, int j, int[] nums) {
        if(i == j) {
            return new Node(i, j, nums[i]);
        }
        int mid = i + (j - i) / 2;
        Node node = new Node(i, j, 0);
        node.left = build(i, mid, nums);
        node.right = build(mid+1, j, nums);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    /**
     * Time O(logn)
     * @param root
     * @param i
     * @param j
     * @return
     */
    public int query(Node root, int i, int j) {
        if(root.i == i && root.j == j) {
            return root.sum;
        }
        int mid = root.i + (root.j - root.i) / 2;
        if(j <= mid) {
            return query(root.left, i, j);
        } else if(mid < i) {
            return query(root.right, i, j);
        } else {
            return query(root.left, i, mid) + query(root.right, mid + 1, j);
        }
    }

    /**
     * Time O(logn)
     * @param root
     * @param index
     * @param val
     */
    public void update(Node root, int index, int val) {
        if(root.i == index && root.j == index) {
            root.sum = val;
            return;
        }
        int mid = root.i + (root.j - root.i) / 2;
        if(index <= mid) {
            update(root.left, index, val);
        } else {
            update(root.right, index, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }
}

class Node {
    int i, j, sum;
    Node left = null, right = null;
    Node(int i, int j, int sum) {
        this.i = i;
        this.j = j;
        this.sum = sum;
    }
}
